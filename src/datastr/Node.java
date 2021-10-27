package datastr;

public class Node<E extends Comparable<E>, P extends Comparable<P>> implements IAVLNode<E>{

	private E element;
	private P parameter;
	private Node<E, P> left;
	private Node<E, P> right;
	private Node<E, P> parent;
	
	public Node(E element, P parameter) {
		setElement(element);
		setParameter(parameter);
	}

	public E getElement() {
		return element;
	}

	public void setElement(E element) {
		this.element = element;
	}

	public Node<E, P> getLeft() {
		return left;
	}

	public void setLeft(Node<E, P> left) {
		this.left = left;
	}

	public Node<E, P> getRight() {
		return right;
	}

	public void setRight(Node<E, P> right) {
		this.right = right;
	}
	
	public Node<E, P> getParent() {
		return parent;
	}

	public void setParent(Node<E, P> parent) {
		this.parent = parent;
	}
	
	public P getParameter() {
		return parameter;
	}
	
	public void setParameter(P parameter) {
		this.parameter = parameter;
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
	
	public int compareTo(Node<E, P> newNode) {
		return parameter.compareTo(newNode.getParameter());
	}
	
}
