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
			roundedSize = size; // use string.format instead
			adjustedSize = String.format("%,8.2f" + " bytes  " + file, roundedSize);
		} else if (size > 1024 && size < (1024 * 1024)) {
			roundedSize = (size / 1024);
			adjustedSize = String.format("%,8.2f" + " KB     " + file, roundedSize);
		} else if (size > (1024 * 1024) && size < (1024 * 1024 * 1024)) {
			roundedSize = (size / (1024 * 1024));
			adjustedSize = String.format("%,8.2f" + " MB     " + file, roundedSize);
		} else {
			roundedSize = (size / (1024 * 1024 * 1024));
			adjustedSize = String.format("%,8.2f" + " GB     " + file, roundedSize);
		}
		String string = (adjustedSize);
		return (string);
	}
	
	public int compareTo (FileOnDisk file) {
		if (this.size > file.getSize()) { // compares by size first
			return 1;
		} else if (this.size < file.getSize()) {
			return -1;
		} else { // if they have the same size, use string compareTo
			if (this.file.compareTo(file.getFile()) > 0)
				return 1;
			else if (this.file.compareTo(file.getFile()) < 0)
				return -1;
			else
				return 0;
		}
	}

}
