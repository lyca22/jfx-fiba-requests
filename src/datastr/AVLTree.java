package datastr;

public class AVLTree<E extends Comparable<E>, P extends Comparable<P>> extends BinaryTree<E, P> implements IAVLTree<E, P>, IAVLNode<E, P>{

	@Override
	public void leftRotate(Node<E, P> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void rightRotate(Node<E, P> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void balance(Node<E, P> node) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Node<E, P> search(P parameter) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int getBalance(Node<E, P> node) {
		int balance = getHeight(node.getRight()) - getHeight(node.getLeft());
		return balance;
	}

	@Override
	public int getHeight(Node<E, P> node) {
		int height = -1;
		if(node != null) {
			int leftHeight = getHeight(node.getLeft());
			int rightHeight = getHeight(node.getRight());
			height = Math.max(leftHeight, rightHeight) + 1;
		}
		return height;
	}
	


}
