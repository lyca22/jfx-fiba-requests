package datastr;

import java.util.ArrayList;

public class Node<E, P extends Comparable<P>> implements Comparable<Node<E, P>>{

	private ArrayList<E> element;
	private P searchParameter;
	private Node<E, P> left;
	private Node<E, P> right;
	private Node<E, P> parent;

	public Node(E element) {
		setElement(new ArrayList<E>());
		this.element.add(element);
	}

	public Node(E element, P searchParameter) {
		setElement(new ArrayList<E>());
		this.element.add(element);
		setSearchParameter(searchParameter);
	}

	public ArrayList<E> getElement() {
		return element;
	}

	public void setElement(ArrayList<E> element) {
		this.element = element;
	}

	public P getSearchParameter() {
		return searchParameter;
	}

	public void setSearchParameter(P searchParameter) {
		this.searchParameter = searchParameter;
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

	public Node<E, P> getPredecessor() {

		Node<E, P> successor = this;

		if(successor.getLeft() != null) {
			successor = successor.getLeft();
			while(successor.getRight() != null) {
				successor = successor.getRight();
			}
		}

		return successor;
	}

	public Node<E, P> getSuccessor() {

		Node<E, P> predeccessor = this;

		if(predeccessor.getRight() != null) {
			predeccessor = predeccessor.getRight();
			while(predeccessor.getLeft() != null) {
				predeccessor = predeccessor.getLeft();
			}
		}

		return predeccessor;
	}

	@Override
	public int compareTo(Node<E, P> newNode) {
		return searchParameter.compareTo(newNode.getSearchParameter());
	}
	
	public void addElement(E element) {
		this.element.add(element);
	}
	
	public void addElements(ArrayList<E> element) {
		this.element.addAll(element);
	}

}
