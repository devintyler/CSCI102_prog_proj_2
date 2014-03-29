package directoryScan;

/** Class GenericNode extends comparable and implements comparable
 * to make sure that only GenericNodes of type T are being compared;
 * This class contains the basic architecture for a generic node;
 * Much of this was taken from "Object-Oriented Data Structures using Java" by Dale, Joyce, and Weems
 * 
 * @author Dale, Joyce, and Weems (text)
 * @author Devin Visslailli (editor)
 * @version 1.0 - CSCI-102 Project 2 - 3/30/14
 * 
 * @param <T>
 * Generic Type T
 */
public class GenericNode<T extends Comparable<T>> implements Comparable<GenericNode<T>> {
	
	/** Creates data of type T */
	private T data;
	/** Creates a node link of type GenericNode<T> */
    private GenericNode<T> link;
    
    /**
     * Constructor for Generic Node
     * @param data
     * Data to be put into node
     */
    public GenericNode(T data){
		this.data = data;
		link = null;
    }
    
    /** Method for setting data
     * @param data
     * Sets data
     */
    public void setData(T data){
    	this.data = data;
    }

    /** Gets Data
     * @return returns data
     */
    public T getData(){
    	return data;
    }

    /** Sets Next or Link
     * @param link
     * Sets link
     */
    public void setLink(GenericNode<T> link){
    	this.link = link;
    }

    /** Gets Next or Link
     * @return the link
     */
    public GenericNode<T> getLink(){
    	return link;
    }
	
    /**
     * Compare to method which directs to the data type compare to (FileOnDisk)
     */
	public int compareTo(GenericNode<T> arg0) { // compareTo which points at FileOnDisk compareTo
		return this.data.compareTo(arg0.data);
	}
}
