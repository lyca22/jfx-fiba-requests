package datastr;

import java.util.ArrayList;
import java.util.List;

public class BinaryTree<E extends Comparable<E>, P extends Comparable<P>> implements IBinaryTree<E, P>{

	private Node<E, P> root;

	public BinaryTree() {}

	public Node<E, P> getRoot() {
		return root;
	}

	public void setRoot(Node<E, P> root) {
		this.root = root;
	}

	@Override
	public void add(E element, P parameter) {
		Node<E, P> newNode = new Node<E, P>(element, parameter);
		if(root == null) {
			root = newNode;
		}else {
			add(root, newNode);
		}
	}

	private void add(Node<E, P> current, Node<E, P> newNode) {
		
		if(newNode.compareTo(current) <= 0) {
			if(current.getLeft() == null) {
				current.setLeft(newNode);
				newNode.setParent(current);
			}else {
				add(current.getLeft(), newNode);
			}
		}else {
			if(current.getRight() == null) {
				current.setRight(newNode);
				newNode.setParent(current);
			}else {
				add(current.getRight(), newNode);
			}
		}
		
	}

	@Override
	public void delete(E element, P parameter) {
		Node<E, P> node = search(element, parameter);
		delete(node);
	}

	private void delete(Node<E, P> node) {
		
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
				
				node.setParent(null);
				
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
				
			}else {
				Node<E, P> successor = node.getSuccessor();
				node.setElement(successor.getElement());
				node.setParameter(successor.getParameter());
				delete(node.getSuccessor());
			}
		}
		
	}

	@Override
	public Node<E, P> search(E element, P parameter) {
		return search(root, element, parameter);
	}
	
	private Node<E, P> search(Node<E, P> current, E element, P parameter) {
		
		if(current == null || (current.getElement().equals(element) && current.getParameter().equals(parameter))) {
			return current;
		}else if(current.getParameter().compareTo(parameter) < 0){
			return search(current.getRight(), element, parameter);
		}else {
			return search(current.getLeft(), element, parameter);
		}
	}

	@Override
	public List<E> searchList(P parameter, ComparisonCriteria criterion) {	
		return searchList(root, parameter, criterion);
	}

	private ArrayList<E> searchList(Node<E, P> current, P parameter, ComparisonCriteria criterion) {
		ArrayList<E> list = new ArrayList<E>();
		if(current != null) {
			if(isValid(current, parameter, criterion)) {
				list.add(current.getElement());
			}
			list.addAll(searchList(current.getLeft(), parameter, criterion));
			list.addAll(searchList(current.getRight(), parameter, criterion));
		}
		
		return list;
	}
	
	public boolean isValid(Node<E, P> node ,P parameter, ComparisonCriteria criterion) {
		boolean valid = false;
		switch (criterion) {
		case MINOR:
			valid = node.getParameter().compareTo(parameter) < 0;
			break;
		case MINOR_EQUAL:
			valid = node.getParameter().compareTo(parameter) <= 0;
			break;
		case EQUAL:
			valid = node.getParameter().compareTo(parameter) == 0;
			break;
		case GREATER_EQUAL:
			valid = node.getParameter().compareTo(parameter) >= 0;
			break;
		case GREATER:
			valid = node.getParameter().compareTo(parameter) > 0;
			break;
		}
		
		return valid;
	}

	@Override
	public E getMinimum() {
		Node<E, P> current = root;
		E minimum = null;
		while(current != null) {
			minimum = current.getElement();
			current = current.getLeft();
		}
		return minimum;
	}

	@Override
	public E getMaximum() {
		Node<E, P> current = root;
		E max = null;
		while(current != null) {
			max = current.getElement();
			current = current.getRight();
		}
		return max;
	}

	@Override
	public boolean isEmpty() {
		return root == null;
	}

	@Override
	public String inorder() {
		String order = "";
		order += inorder(root);
		return order;
	}

	private String inorder(Node<E, P> node) {
		String order = "";
		if(node.getLeft() != null) {
			order += inorder(node.getLeft()) + " ";
		}
		
		order += node.getElement() + " ";
		
		if(node.getRight() != null) {
			order+= inorder(node.getRight()) + " ";
		}
		
		return order;
	}

}
