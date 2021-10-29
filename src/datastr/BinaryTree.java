package datastr;

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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<E> searchList(P parameter, ComparisonCriteria criterion) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getMinimum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public E getMaximum() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

}
