package directoryScan;

public class GenericNode<T> {
	private T data;
    private GenericNode<T> link;

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
}
