package directoryScan;

import java.io.*;

/** Class DirectorySize implements the program;
 * It reads in information from the command line,
 * verifies it, and explores the directory and creates output;
 * The first command is the directory and the second is the number
 * of largest files desired at the output
 * 
 * @author Devin Visslailli
 * @version 1.0 - CSCI-102 Project 2 - 3/30/14
 */
public class DirectorySize {
	
	/** Creates a Generic Sorted Linked List to be used to hold files of type FileOnDisk */
	private static GenericSortedLinkedList<FileOnDisk> list = new GenericSortedLinkedList<FileOnDisk>(null);
	/** Total size of the directory */
	private static double totalSize = 0;
	
	/** Main method which runs the program;
	 * This method error checks, and initiates exploreDir() method;
	 * It also prints all results to the screen
	 * 
	 * @param args
	 * @throws IOException
	 */
	public static void main(String[] args) throws IOException {
		// Validate amount of arguments
		if (args.length != 2) {
			System.err.println("Error: there are not two arguments");
			System.exit(0);
		}
		
		// set first arg to File so it can be used later
		File dir = new File(args[0]);
		
		// check to make sure it exists
		if (!dir.exists()) {
			System.err.println("Error: this file/directory does not exist");
			System.exit(0);
		}
		
		// Check to make sure this new file is a directory
		if (dir.isDirectory()) {
//			System.out.println("This is a directory");
			System.out.println("Directory Path: " + dir.getAbsolutePath() + "\n");
		} else if (dir.isFile()) {
//			System.out.println("This is a file");
			System.out.println("File Path: " + dir.getAbsolutePath() + "\n");
		} else {
			System.err.println("Error: this is not a file or a directory, you broke it.");
			System.exit(0);
		}
		
		// set second arg to int
		int numOfDir = Integer.parseInt(args[1]);
		
		// Check and make sure number is positive
		if (numOfDir < 0) {
			System.err.println("Error: the number of directories given to check is negative");
			System.exit(0);
		}
		
		if (dir.isDirectory()) {
			totalSize -= dir.length(); // gets rid of original directory size
		}
		
		// initiates the directory explorer method
		exploreDir(dir);
		
		// print Total Size
		System.out.println("Total size:  " + print(totalSize));
		
		// print number of files to be printed
		System.out.println("Largest " + numOfDir + " (or less) files:\n");
		
		// **** Uncomment following code to print all files ****
//		System.out.println(list.toString());
		
		// prints args[1] largest files
		System.out.println(list.toStringMaxNum(numOfDir));

	}
	
	/** Explores the directory given;
	 * It recursively calls itself when a sub-directory is found
	 * Files are taken and added to the Generic Sorted Linked List
	 * 
	 * @param dir
	 * Object dir of type File is used for exploring original and sub-directories
	 * @return exploreDir which is a recursive return call
	 */
	public static double exploreDir(File dir) {
		
		// if file is directory
		if (dir.isDirectory()) {
			
			// add to total size
			totalSize += dir.length();
			
			// creates new File[] array with array of files/dir
			File[] newFileList = dir.listFiles();
			
			// for each file and directory in directory
			for (int i = 0; i < newFileList.length; i++) {
				dir = newFileList[i];
				exploreDir(dir); // recursive formula
			}
			
		} else {
			// add to total size
			totalSize += dir.length();
			FileOnDisk file = new FileOnDisk(dir.getAbsolutePath(), dir.length()); // makes new file object
			
			// insert file into sorted list
			list.insert(file);
		}
		
		return totalSize; // returns total size
	}
	
	/** Prints given byte sizes into the correct format;
	 * Also formats the string properly
	 * 
	 * @param size
	 * Given size in bytes
	 * @return Returns the adjusted size for printing
	 */
	public static String print(double size) { // method for printing size properly [incl formatting]
		String adjustedSize = ""; // instantiates string
		double roundedSize = 0; // instantiates double
		if (size < 1024) { // if it is less than a KB
			roundedSize = size; // use string.format instead
			adjustedSize = String.format("%,8.2f" + " bytes  ", roundedSize);
		} else if (size > 1024 && size < (1024 * 1024)) { // if KB
			roundedSize = (size / 1024);
			adjustedSize = String.format("%,8.2f" + " KB     ", roundedSize);
		} else if (size > (1024 * 1024) && size < (1024 * 1024 * 1024)) { // if MB
			roundedSize = (size / (1024 * 1024));
			adjustedSize = String.format("%,8.2f" + " MB     ", roundedSize);
		} else { // if GB (TB is too large)
			roundedSize = (size / (1024 * 1024 * 1024));
			adjustedSize = String.format("%,8.2f" + " GB     ", roundedSize);
		}
		return adjustedSize; // return formatted size
	}

}
