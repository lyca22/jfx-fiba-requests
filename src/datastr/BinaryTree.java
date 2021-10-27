package datastr;

import java.util.List;

public class BinaryTree<E extends Comparable<E>, P> implements IBinaryTree<E, P>{

	private Node<E> root;

	public BinaryTree() {}

	public Node<E> getRoot() {
		return root;
	}

	public void setRoot(Node<E> root) {
		this.root = root;
	}

	@Override
	public void add(E element) {
		Node<E> newNode = new Node<E>(element);
		if(root == null) {
			root = newNode;
		}else {
			add(root, newNode, root);
		}
	}

	private void add(Node<E> current, Node<E> newNode, Node<E> parent) {
		int side = -1;
		
		while(current != null) {
			parent = current;
			//Pending to change
			if(current.getElement().compareTo(newNode.getElement()) <= 0) {
				side = 1; //left
			}
		}
		
	}

	@Override
	public void delete(E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public Node<E> search(P parameter) {
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
