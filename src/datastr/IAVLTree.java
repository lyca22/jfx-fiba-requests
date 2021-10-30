package datastr;

public interface IAVLTree<E extends Comparable<E>, P extends Comparable<P>> {
	
	public Node<E, P> leftRotate(Node<E, P> node);
	public Node<E, P> rightRotate(Node<E, P> node);
	public void balance(Node<E, P> node);
	
}
