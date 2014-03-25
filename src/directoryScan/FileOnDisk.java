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
		float roundedSize = 0;
		if (size < 1024) {
			roundedSize = size;
			adjustedSize = (roundedSize + " bytes");
		} else if (size > 1024 && size < (1024 * 1024)) {
			roundedSize = (float)Math.round((size / 1024) * 100) / 100;
			adjustedSize = (roundedSize + " KB");
		} else if (size > (1024 * 1024) && size < (1024 * 1024 * 1024)) {
			roundedSize = (float)Math.round((size / (1024 * 1024)) * 100) / 100;
			adjustedSize = (roundedSize + " MB");
		} else {
			roundedSize = (float)Math.round((size / (1024 * 1024 * 1024)) * 100) / 100;
			adjustedSize = (roundedSize + " GB");
		}
		String string = (adjustedSize + " " + file);
		return (string);
	}
	
	public void compareTo (float size) {
		// Not sure how to write this TODO
	}

}
