package directoryScan;

public class GenericNode<T> {
	private T data;
    private GenericNode<T> link;
    private double size; // TODO fix size

    public GenericNode(T data){
		this.data = data;
		link = null;
    }

    public void setData(T data){
    	this.data = data;
    }

    public T getData(){
    	return data;
    }

    public void setLink(GenericNode<T> link){
    	this.link = link;
    }

    public GenericNode<T> getLink()
    {
    	return link;
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
    
//    public int compareTo (GenericNode<T> genericNode) {
//		if (this.size > genericNode.getSize()) {
//			return 1;
//		} else if (this.size < genericNode.getSize()) {
//			return -1;
//		} else { // if they have the same size, use string compareTo
//			if (this.file.compareTo(file.getFile()) > 0)
//				return 1;
//			else if (this.file.compareTo(file.getFile()) < 0)
//				return -1;
//			else
//				return 0;
//		}
//	}
}
