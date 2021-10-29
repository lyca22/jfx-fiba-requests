package datastr;

public interface IAVLNode<E extends Comparable<E>, P extends Comparable<P>>{
	
	public int getBalance(Node<E, P> node);
	public int getHeight(Node<E, P> node);
}
