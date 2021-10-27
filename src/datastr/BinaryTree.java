package datastr;

import java.util.List;

public class BinaryTree<E, P> implements IBinaryTree<E, P>{

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
		// TODO Auto-generated method stub

	}

	@Override
	public void delete(E element) {
		// TODO Auto-generated method stub

	}

	@Override
	public E search(P parameter) {
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
