package directoryScan;

import java.io.*;

public class FileOnDisk {
	
	private String file;
	private double size;
	
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
	public double getSize() {
		return size;
	}

	/**
	 * @param size the size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}
	
	FileOnDisk (String file, double size) {
		this.file = file;
		this.size = size;
	}
	
	public String toString() {
		String adjustedSize = "";
		double roundedSize = 0;
		if (size < 1024) {
			roundedSize = size;
			adjustedSize = (roundedSize + " bytes");
		} else if (size > 1024 && size < (1024 * 1024)) {
			roundedSize = (double)Math.round((size / 1024) * 100) / 100;
			adjustedSize = (roundedSize + " KB");
		} else if (size > (1024 * 1024) && size < (1024 * 1024 * 1024)) {
			roundedSize = (double)Math.round((size / (1024 * 1024)) * 100) / 100;
			adjustedSize = (roundedSize + " MB");
		} else {
			roundedSize = (double)Math.round((size / (1024 * 1024 * 1024)) * 100) / 100;
			adjustedSize = (roundedSize + " GB");
		}
		String string = (adjustedSize + " " + file);
		return (string);
	}
	
	public int compareTo (FileOnDisk file) {
		if (this.size > file.getSize()) {
			return 1;
		} else if (this.size < file.getSize()) {
			return -1;
		} else {
			return 0;
		}
	}

}
