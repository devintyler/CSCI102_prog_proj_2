package directoryScan;

import java.io.*;
import java.util.*;

public class DirectorySize {
	
	// TODO create private LinkedList data field here
	
	private static float totalSize = 0;

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
			System.out.println("Directory Name: " + dir + " [" + dir.length() + "]\n");
		} else if (dir.isFile()) {
			System.out.println("This is a file");
			System.out.println("Directory Name: " + dir + " [" + dir.length() + "]\n");
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
		
		totalSize -= dir.length(); // gets rid of original directory size
		exploreDir(dir);
		
		System.out.print("\nTotal found size is " + totalSize);
		
		// TODO print results to console

	}
	
	public static float exploreDir(File dir) {
		
		// if file is directory
		if (dir.isDirectory()) {
			
			// add to total size
			totalSize += dir.length();
			
			// creates new File[] array with array of files/dir
			File[] newFileList = dir.listFiles();
			
			System.out.println("D: " + totalSize + " [" + dir.length() + "] " + dir);
			
			// for each file and directory in directory
			for (int i = 0; i < newFileList.length; i++) {
				dir = newFileList[i];
				exploreDir(dir); // recursive formula
			}
			
		} else {
			// add to total size
			totalSize += dir.length();
			// using system.err to boldly show files
			System.err.println("F: " + totalSize + " [" + dir.length() + "] " + dir);
			
			// TODO add file to list of files
		} // maybe add error check for ones that don't fit either
		
		return totalSize;
	}

}
