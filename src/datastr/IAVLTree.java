package datastr;

public interface IAVLTree<E extends Comparable<E>, P extends Comparable<P>> {
	
	public void leftRotate(Node<E, P> node);
	public void rightRotate(Node<E, P> node);
	public void balance(Node<E, P> node);
	
}
