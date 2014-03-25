package directoryScan;

public class FileOnDisk {
	
	private String file;
	private float size;
	
	/**
	 * @return the file
	 */
	public String getFile() {
		return file;
	}

	/**
	 * @param file the file to set
	 */
	public void setFile(String file) {
		this.file = file;
	}

	/**
	 * @return the size
	 */
	public float getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(float size) {
		this.size = size;
	}
	
	FileOnDisk (String file, float size) {
		this.file = file;
		this.size = size;
	}
	
	public String toString() {
		String adjustedSize = "";
		if (size < 1024) {
			adjustedSize = (size + " bytes");
		} else if (size > 1024 && size < (1024 * 1024)) {
			adjustedSize = ((size / 1024) + " KB");
		} else if (size > (1024 * 1024) && size < (1024 * 1024 * 1024)) {
			adjustedSize = ((size / (1024 * 1024)) + " MB");
		} else {
			adjustedSize = ((size / (1024 * 1024 * 1024)) + " GB");
		}
		String string = (adjustedSize + "    " + file);
		return (string);
	}
	
	public void compareTo (float size) {
		// Not sure how to write this
	}

}
