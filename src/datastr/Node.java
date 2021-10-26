package datastr;

public class Node<E> {

	private E element;
	private Node<E> left;
	private Node<E> right;
	
	public Node(E element) {
		setElement(element);
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Node<E> getLeft() {
		return left;
	}

	public void setLeft(Node<E> left) {
		this.left = left;
	}

	public Node<E> getRight() {
		return right;
	}

	public void setRight(Node<E> right) {
		this.right = right;
	}
	
	public E getSuccessor() {
		//TODO Implement method.
		return null;
	}
	public E getPredecessor() {
		//TODO Implement method.
		return null;
	}
	
}
