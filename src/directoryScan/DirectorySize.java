package directoryScan;

import java.io.*;
import java.util.*;

public class DirectorySize {
	
	// create private LinkedList data field here
	private static GenericSortedLinkedList<FileOnDisk> list = null;
	private static double totalSize = 0;

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
			System.out.println("This is a directory");
			System.out.println("Directory Name: " + dir + "\n");
		} else if (dir.isFile()) {
			System.out.println("This is a file");
			System.out.println("Directory Name: " + dir + "\n");
		} else {
			System.err.println("Error: this is NOTHING");
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
		exploreDir(dir);
		
		// print Total Size
		System.out.println("\nTotal size: " + print(totalSize));
		
		// TODO print results to console

	}
	
	public static double exploreDir(File dir) {
		
		// if file is directory
		if (dir.isDirectory()) {
			
			// add to total size
			totalSize += dir.length();
			
			// creates new File[] array with array of files/dir
			File[] newFileList = dir.listFiles();
			
			System.out.println("D: " + print(dir.length()) + dir.getAbsolutePath());
			
			// for each file and directory in directory
			for (int i = 0; i < newFileList.length; i++) {
				dir = newFileList[i];
				exploreDir(dir); // recursive formula
			}
			
		} else {
			// add to total size
			totalSize += dir.length();
			FileOnDisk file = new FileOnDisk(dir.getAbsolutePath(), dir.length()); // makes new file object
			
			// using system.err to boldly show files
//			System.out.println("F: " + totalSize + " [" + dir.length() + "] " + dir);
			System.out.printf("F: %10s\n", file.toString());
			
			// TODO add file to list of files
//			GenericNode<FileOnDisk> newNode = new GenericNode<FileOnDisk>(file);
			list.insert(file);
			
		} // maybe add error check for ones that don't fit either
		
		return totalSize;
	}
	
	public static String print(double size) { // method for printing size properly
		String adjustedSize = "";
		double roundedSize = 0;
		if (size < 1024) {
			roundedSize = size; // use string.format instead
			adjustedSize = String.format("%,8.2f" + " bytes  ", roundedSize);
		} else if (size > 1024 && size < (1024 * 1024)) {
			roundedSize = (size / 1024);
			adjustedSize = String.format("%,8.2f" + " KB     ", roundedSize);
		} else if (size > (1024 * 1024) && size < (1024 * 1024 * 1024)) {
			roundedSize = (size / (1024 * 1024));
			adjustedSize = String.format("%,8.2f" + " MB     ", roundedSize);
		} else {
			roundedSize = (size / (1024 * 1024 * 1024));
			adjustedSize = String.format("%,8.2f" + " GB     ", roundedSize);
		}
		return adjustedSize;
	}

}
