package directoryScan;

public class FileOnDisk {
	
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

	private String file;
	private float size;
	
	FileOnDisk (String file, float size) {
		this.file = file;
		this.size = size;
	}

}
