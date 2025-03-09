package com.fd.myunrar;

/**
 * 解压的文件数据信息
 * 
 * @author fudong
 *
 */
public class UnFileDataInfo {
	/**
	 * 文件数据
	 */
	private byte[] filedata;

	private String filename;

	private String contentType;

	public byte[] getFiledata() {
		return filedata;
	}

	public void setFiledata(byte[] filedata) {
		this.filedata = filedata;
	}

	public String getFilename() {
		return filename;
	}

	public void setFilename(String filename) {
		this.filename = filename;
	}

	public UnFileDataInfo(byte[] filedata, String filename, String contentType) {
		super();
		this.filedata = filedata;
		this.filename = filename;
		this.contentType = contentType;
	}

	public UnFileDataInfo() {
		super();
	}

	public String getContentType() {
		return contentType;
	}

	public void setContentType(String contentType) {
		this.contentType = contentType;
	}

}
