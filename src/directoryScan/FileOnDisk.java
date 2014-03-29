package directoryScan;

/** Class FileOnDisk is used as an object for files
 * that are picked up by the exploreDir in the DirectorySize Class;
 * It contains setters and getters for String file and double size,
 * a toString method which formats the file string properly,
 * and a compareTo method which is used for ordering the list
 * 
 * @author Devin Visslailli
 * @version 1.0 - CSCI-102 Project 2 - 3/30/14
 */
public class FileOnDisk implements Comparable<FileOnDisk> {
	
	/** Creates string path to be used as the string which contains the absolute path of the file */
	private String path;
	/** Creates a double called size which holds the file size */
	private double size;
	
	/**
	 * @return The absolute path
	 */
	public String getPath() {
		return path;
	}

	/** Method for setting absolute path
	 * @param path
	 * Sets absolute path
	 */
	public void setPath(String file) {
		this.path = file;
	}

	/**
	 * @return The size of the file
	 */
	public double getSize() {
		return size;
	}

	/** Method for setting the size
	 * @param size
	 * The size to set
	 */
	public void setSize(double size) {
		this.size = size;
	}
	
	/** Constructor for FileOnDisk setting path and size of file
	 * 
	 * @param path
	 * The path given
	 * @param size
	 * The size given
	 */
	public FileOnDisk (String path, double size) {
		this.path = path;
		this.size = size;
	}
	
	/**
	 * To string method which formats the file size properly for printing
	 */
	public String toString() {
		String adjustedSize = "";
		double roundedSize = 0;
		if (size < 1024) {
			roundedSize = size; // use string.format instead
			adjustedSize = String.format("%,8.2f" + " bytes  " + path, roundedSize);
		} else if (size > 1024 && size < (1024 * 1024)) {
			roundedSize = (size / 1024);
			adjustedSize = String.format("%,8.2f" + " KB     " + path, roundedSize);
		} else if (size > (1024 * 1024) && size < (1024 * 1024 * 1024)) {
			roundedSize = (size / (1024 * 1024));
			adjustedSize = String.format("%,8.2f" + " MB     " + path, roundedSize);
		} else {
			roundedSize = (size / (1024 * 1024 * 1024));
			adjustedSize = String.format("%,8.2f" + " GB     " + path, roundedSize);
		}
		String string = (adjustedSize);
		return (string);
	}
	
	/**
	 * Compare to method which overrides standard compare to;
	 * Checks for file size and determines in a list which file is larger;
	 * Also if the sizes are equal, it checks alphabetical order
	 */
	@Override
	public int compareTo(FileOnDisk file) {
		if (this.size > file.getSize()) { // compares by size first
			return 1;
		} else if (this.size < file.getSize()) {
			return -1;
		} else { // if they have the same size, use string compareTo
			if (this.path.compareTo(file.getPath()) > 0)
				return -1;
			else if (this.path.compareTo(file.getPath()) < 0)
				return 1;
			else
				return 0;
		}
	}

}
