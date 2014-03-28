package directoryScan;

public class GenericSortedLinkedList<T> {
	// TODO don't forget to sort this list
	
	protected GenericNode<T> head;
    protected T data;

    public GenericSortedLinkedList(T value) {
	    head = null;
	    this.data = value;
	}
    
    public void insert(T element) {
    	// TODO make sorted using compareTo in FileOnDisk File.compareTo(node)
		GenericNode<T> newNode = new GenericNode<T>(element);
		GenericNode<T> current = new GenericNode<T>(element);
		current.setLink(head);
		boolean end = false;
		while (!end) {
			if (newNode.compareTo(newNode.getLink()) > 0) {
				head = newNode; //adds new data to the beginning of the list
				// TODO don't forget to link new node to next node in each of these
				end = true;
			} else if (newNode.compareTo(newNode.getLink()) < 0) {
				newNode = newNode.getLink();
			} else {
				// figure out how to sort alpha...
			}
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

    public T getName() {
    	return data;
    }

    public int size() {
		int count = 0;
		GenericNode<T> node;
		node = head;
		while(node != null)
		    {
			count++;
			node = node.getLink();
		    }
		return count;
    }
    
    @Override
    public String toString() {
    	String list = ""; // instantiates string to be returned
    	// might want to change size of loop to be inputed size instead
    	for (int i = 0; i < size(); i++) { // loop for going through list
    		list = list + data + "\n"; // puts each item on new line
    	}
    	return list; // returns whole list string
    }
    
    public String toStringMaxNum(int n) {
    	// same as above except the loop uses n instead of size()
    	// not sure why this exists yet?
    	return "";
    }
}
