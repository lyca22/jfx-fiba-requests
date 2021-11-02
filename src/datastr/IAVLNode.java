package datastr;

public interface IAVLNode<E, P extends Comparable<P>>{
	
	//TODO Remember to delete this if we don't use it at the end.
	
	public int getBalance(Node<E, P> node);
	public int getHeight(Node<E, P> node);
	
}
