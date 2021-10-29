package datastr;

public class Node<E extends Comparable<E>, P extends Comparable<P>> implements INode<E, P>{

	private E element;
	private P parameter;
	private Node<E, P> left;
	private Node<E, P> right;
	private Node<E, P> parent;
	
	public Node(E element, P parameter) {
		setElement(element);
		setParameter(parameter);
	}
	
	public Node(E element) {
		setElement(element);
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

	public Node<E, P> getSuccessor() {
		Node<E, P> successor = this;
		if(successor.getLeft() != null) {
			successor = successor.getLeft();
			
			while(successor.getRight() != null) {
				successor = successor.getRight();
			}
		}

		return successor;
	}
	
	public Node<E, P> getPredecessor() {
		Node<E, P> predeccessor = this;
		if(predeccessor.getRight() != null) {
			predeccessor = predeccessor.getRight();
			while(predeccessor.getLeft() != null) {
				predeccessor = predeccessor.getLeft();
			}
		}
		
		return predeccessor;
	}
	
	public int compareTo(Node<E, P> newNode) {
		return parameter.compareTo(newNode.getParameter());
	}
	
}
