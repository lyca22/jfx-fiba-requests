package datastr;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E, P extends Comparable<P>> implements IBinaryTree<E, P>{

	private Node<E, P> root;

	public BinaryTree() {}

	public Node<E, P> getRoot() {
		return root;
	}

	public void setRoot(Node<E, P> root) {
		this.root = root;
	}

	@Override
	public void add(E element, P searchParameter) {

		Node<E, P> newNode = new Node<E, P>(element, searchParameter);

		if(root == null) {
			root = newNode;
		}else {
			add(root, newNode);
		}
	}

	private void add(Node<E, P> current, Node<E, P> newNode) {
		if(newNode.compareTo(current) < 0) {
			if(current.getLeft() == null) {
				current.setLeft(newNode);
				newNode.setParent(current);
			}else {
				add(current.getLeft(), newNode);
			}
		}else if(newNode.compareTo(current) > 0){
			if(current.getRight() == null) {
				current.setRight(newNode);
				newNode.setParent(current);
			}else {
				add(current.getRight(), newNode);
			}
		}else {
			current.addElements(newNode.getElement());
		}
	}

	@Override
	public Node<E, P> search(P parameter) {
		return search(root, parameter);
	}

	private Node<E, P> search(Node<E, P> current, P parameter) {
		if(current == null || current.getSearchParameter().equals(parameter)) {
			return current;
		}else if(current.getSearchParameter().compareTo(parameter) < 0){
			return search(current.getRight(), parameter);
		}else {
			return search(current.getLeft(), parameter);
		}
	}

	@Override
	public Node<E, P> delete(E element, P parameter) {
		Node<E, P> node = search(parameter);
		if(node != null) {
			if(node.getElement().contains(element)) {
				node.getElement().remove(element);
				if(node.getElement().isEmpty()) {
					return delete(node);
				}
			}
		}
		return node;
	}

	private Node<E, P> delete(Node<E, P> node) {

		Node<E, P> returnedParent = null;

		if (node != null) {

			if(node.getLeft() == null && node.getRight() == null) {

				if(node.equals(root)) {
					root = null;
				}else {
					if(node.getParent().compareTo(node) < 0) {
						node.getParent().setRight(null);
					}else {
						node.getParent().setLeft(null);
					}
				}

				returnedParent = node.getParent();
				node.setParent(null);

			}else if(node.getLeft() != null && node.getRight() != null){

				Node<E, P> successor = node.getSuccessor();
				node.setElement(successor.getElement());
				node.setSearchParameter(successor.getSearchParameter()); 
				returnedParent = delete(successor);

			}else if(node.getLeft() != null || node.getRight() != null) {

				Node<E, P> child;
				if(node.getLeft() == null) {
					child = node.getRight();
				}else {
					child = node.getLeft();
				}

				child.setParent(node.getParent());

				if(node == root) {
					root = child;
				}else if(node.compareTo(node.getParent()) <= 0) {
					node.getParent().setLeft(child);
				}else {
					node.getParent().setRight(child);
				}

				returnedParent = child.getParent();

			}
		}

		return returnedParent;

	}

	@Override
	public List<E> searchList(P parameter, ComparisonCriteria criterion) {
		return searchList(root, parameter, criterion);
	}

	private ArrayList<E> searchList(Node<E, P> current, P parameter, ComparisonCriteria criterion) {
		ArrayList<E> list = new ArrayList<E>();
		switch (criterion) {
		case MINOR:
			list = minorSearchList(current, parameter, list);
			break;
		case MINOR_EQUAL:
			list = minorEqualSearchList(current, parameter, list);
			break;
		case EQUAL:
			list = search(current, parameter).getElement();
			break;
		case GREATER_EQUAL:
			list = greaterEqualSearchList(current, parameter, list);
			break;
		case GREATER:
			list = greaterSearchList(current, parameter, list);
			break;
		}
		return list;
	}

	private ArrayList<E> minorSearchList(Node<E, P> current, P parameter, ArrayList<E> list){
		if(current != null) {
			if(current.getSearchParameter().compareTo(parameter) < 0) {
				list = minorSearchList(current.getRight(), parameter, list);
				list.addAll(current.getElement());
			}
			list = minorSearchList(current.getLeft(), parameter, list);
		}
		return list;
	}

	private ArrayList<E> minorEqualSearchList(Node<E, P> current, P parameter, ArrayList<E> list){
		if(current != null) {
			if(current.getSearchParameter().compareTo(parameter) <= 0) {
				list = minorEqualSearchList(current.getRight(), parameter, list);
				list.addAll(current.getElement());
			}
			list = minorEqualSearchList(current.getLeft(), parameter, list);
		}
		return list;
	}

	private ArrayList<E> greaterEqualSearchList(Node<E, P> current, P parameter, ArrayList<E> list){
		if(current != null) {
			if(current.getSearchParameter().compareTo(parameter) >= 0) {
				list = greaterEqualSearchList(current.getLeft(), parameter, list);
				list.addAll(current.getElement());
			}
			list = greaterEqualSearchList(current.getRight(), parameter, list);
		}
		return list;
	}

	private ArrayList<E> greaterSearchList(Node<E, P> current, P parameter, ArrayList<E> list){
		if(current != null) {
			if(current.getSearchParameter().compareTo(parameter) > 0) {
				list = greaterSearchList(current.getLeft(), parameter, list);
				list.addAll(current.getElement());
			}
			list = greaterSearchList(current.getRight(), parameter, list);
		}
		return list;
	}

	@Override
	public ArrayList<E> getMinimum() {
		Node<E, P> current = root;
		ArrayList<E> minimum = null;
		while(current != null) {
			minimum = current.getElement();
			current = current.getLeft();
		}
		return minimum;
	}

	@Override
	public ArrayList<E> getMaximum() {
		Node<E, P> current = root;
		ArrayList<E> maximum = null;
		while(current != null) {
			maximum = current.getElement();
			current = current.getRight();
		}
		return maximum;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

}
