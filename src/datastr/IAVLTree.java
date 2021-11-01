package datastr;

public interface IAVLTree<E, P extends Comparable<P>> {
	
	public Node<E, P> leftRotate(Node<E, P> node);
	public Node<E, P> rightRotate(Node<E, P> node);
	public void balance(Node<E, P> node);
	public int getBalance(Node<E, P> node);
	public int getHeight(Node<E, P> node);
	
}
