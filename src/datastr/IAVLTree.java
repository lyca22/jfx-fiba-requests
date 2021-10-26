package datastr;

public interface IAVLTree<E, P> {
	
	public void leftRotate(Node<E> node);
	public void rightRotate(Node<E> node);
	public void balance(Node<E> node);
	
}
