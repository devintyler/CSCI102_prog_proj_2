package directoryScan;

import java.io.*;

public class DirectorySize {
	
	// TODO create private LinkedList data field here

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
		} else if (dir.isFile()) {
			System.out.println("This is a file");
			System.exit(0);
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
		
		exploreDir(dir);
		
		// TODO print results to console

	}
	
	public static float exploreDir(File dir) {
		
		
		return 0;
	}

}
