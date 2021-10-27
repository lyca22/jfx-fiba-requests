package datastr;

public class Node<E> implements IAVLNode<E>{

	private E element;
	private Node<E> left;
	private Node<E> right;
	private Node<E> parent;
	
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
	
	public Node<E> getParent() {
		return parent;
	}

	public void setParent(Node<E> parent) {
		this.parent = parent;
	}

	public E getSuccessor() {
		//TODO Implement method.
		return null;
	}
	public E getPredecessor() {
		//TODO Implement method.
		return null;
	}

	@Override
	public int getBalance() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getHeight() {
		// TODO Auto-generated method stub
		return 0;
	}
	
}
