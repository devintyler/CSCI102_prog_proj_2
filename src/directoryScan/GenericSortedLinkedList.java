package directoryScan;

/** Class GenericSortedLinkedList extends comparable
 * so that the objects that are given can be sorted;
 * Contains methods for defining the list, inserting, and two to string methods;
 * Much of this was taken from "Object-Oriented Data Structures using Java" by Dale, Joyce, and Weems
 * 
 * @author Dale, Joyce, and Weems (text)
 * @author Devin Visslailli (editor)
 * @version 1.0 - CSCI-102 Project 2 - 3/30/14
 * 
 * @param <T>
 * Generic Type T
 */
public class GenericSortedLinkedList<T extends Comparable<T>> {
	
	/** Creates head node which is at the beginning of the list */
	protected GenericNode<T> head;
	/** Creates data of type T */
    protected T data;
    
    /**
     * Creates the linked list
     * @param value
     * The value(s) in the list at first
     */
    public GenericSortedLinkedList(T value) { // constructor
	    head = null;
	    this.data = value;
	}
    
    /**
     * Insert method for the linked list;
     * It includes sorting abilities by using the GenericNode compareTo method,
     * which links to the FileOnDisk compareTo method
     * @param element
     * The inserted data of type T
     */
	public void insert(T element) {
		GenericNode<T> prev = null; // trail reference point
		GenericNode<T> current = head; // current node
		T listElement; // current element being compared
		
		while (current != null) { // find where it belongs
			listElement = current.getData();
			if (listElement.compareTo(element) > 0) {
				prev = current;
				current = current.getLink();
			} else {
				break;
			}
		}
		
		GenericNode<T> newNode = new GenericNode<T>(element); // create new node
		if (prev == null){ // if this is the first node, insert it
			newNode.setLink(head);
			head = newNode;
		} else { // otherwise put it in its spot
			newNode.setLink(current);
			prev.setLink(newNode);
		}
    }

//    public void clear() 
//    {
//    	head = null;
//    }

//    public boolean isFull() {
//		//always returns false because this is an unbound linkedlist.
//		return false;
//    }
	
	/**
	 * Allows the getting of the data
	 * @return the data
	 */
    public T getName() {
    	return data;
    }

//    public int size() {
//		int count = 0;
//		GenericNode<T> node;
//		node = head;
//		while(node != null)
//		    {
//			count++;
//			node = node.getLink();
//		    }
//		return count;
//    }
    
    /**
     * Overrides normal toString method;
     * Goes through elements in the list and returns them to be printed
     * @return returns string of data to be printed
     */
    @Override
    public String toString() {
    	GenericNode<T> current = head; // instantiates current node
    	String list = ""; // instantiates string to be returned
    	while (current != null) { // while current has data
    		list = list + "" + current.getData() + "\n";
    		current = current.getLink();
    	}
    	return list; // returns whole list string
    }
    
    /**
     * This is the used toString method because of its limiting abilities
     * for the max number of elements;
     * It only prints the number of elements asked for in args[1]
     * 
     * @param n
     * number representing args[1]
     * @return returns string of data to be printed
     */
    public String toStringMaxNum(int n) {
    	GenericNode<T> current = head; // instantiates current node
    	String list = ""; // instantiates string to be returned
    	for (int i = 0; i < n; i++) { // for number of n files given by args[1]
    		if (current == null) // if there are no more files, break
    			break;
    		else { // if there are files to be counted
		    	list = list + "" + current.getData() + "\n";
		    	current = current.getLink();
    		}
	    }
    	return list; // returns whole list string
    }
}
