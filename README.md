RAR 文件 解压



```


	public static void main(String[] args) throws RarException, IOException {

		File rar = new File("g:/视频.rar");
		List<FileDataInfo> files = getUnrarFiles(Files.readAllBytes(rar.toPath()));
		for (FileDataInfo f : files) {
			Files.write(Paths.get("g:/视频", f.getFilename()), f.getFiledata());
		}

	}

```
