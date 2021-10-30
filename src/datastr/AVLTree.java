package datastr;

public class AVLTree<E extends Comparable<E>, P extends Comparable<P>> extends BinaryTree<E, P> implements IAVLTree<E, P>, IAVLNode<E, P>{

	@Override
	public void add(E element, P parameter) {
		super.add(element, parameter);
		Node<E, P> added = search(element, parameter);
		balance(added);
	}
	
	@Override
	public Node<E, P> leftRotate(Node<E, P> node) {
		Node<E, P> right = node.getRight();
		Node<E, P> subOfRight = right.getLeft();
		
		
		right.setLeft(node);
		node.setRight(subOfRight);
		return right;
	}

	@Override
	public Node<E, P> rightRotate(Node<E, P> node) {
		Node<E, P> left = node.getLeft();
		Node<E, P> subOfLeft = left.getRight();
		
		left.setRight(node);
		left.setLeft(subOfLeft);
		return left;
	}

	@Override
	public void balance(Node<E, P> node) {
		if(node != null) {
			int balance = getBalance(node);
			if(balance > 1 && node.compareTo(node.getLeft()) <= 0) {
				rightRotate(node);
			}
			
			if(balance < -1 && node.compareTo(node.getRight()) > 0) {
				leftRotate(node);
			}
			
			if(balance > 1 && node.compareTo(node.getLeft()) >= 0) {
				node.setLeft(leftRotate(node.getLeft()));
				rightRotate(node);
			}
			
			if(balance < -1 && node.compareTo(node.getRight()) < 0) {
				node.setRight(rightRotate(node.getRight()));
				leftRotate(node);
			}
			
			balance(node.getParent());
		}
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
