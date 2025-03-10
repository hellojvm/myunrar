package com.fd.myunrar;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.List;

import com.github.junrar.Archive;
import com.github.junrar.exception.RarException;
import com.github.junrar.rarfile.FileHeader;

/**
 * 解压缩 RAR 文件
 */
public final class MyUnrarUtils {

	public static List<UnFileDataInfo> getUnrarFiles(byte[] bts) throws IOException, RarException {
		List<UnFileDataInfo> files = new ArrayList<UnFileDataInfo>();
		try (Archive archive = new Archive(new ByteArrayInputStream(bts));) {
			List<FileHeader> fhds = archive.getFileHeaders();
			for (FileHeader hd : fhds) {
				if (!hd.isDirectory()) {
					try (ByteArrayOutputStream os = new ByteArrayOutputStream();) {
						archive.extractFile(hd, os);
						byte[] byteArray = os.toByteArray();
						String contentType = URLConnection.guessContentTypeFromName(hd.getFileName());
						if (contentType == null) {
							try (ByteArrayInputStream is = new ByteArrayInputStream(byteArray);) {
								contentType = URLConnection.guessContentTypeFromStream(is);
							}
						}
						files.add(new UnFileDataInfo(byteArray, hd.getFileName(), contentType));
					}
				}
			}

		}
		return files;
	}
}
