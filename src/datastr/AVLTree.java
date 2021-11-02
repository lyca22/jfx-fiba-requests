package datastr;

public class AVLTree<E, P extends Comparable<P>> extends BinaryTree<E, P> implements IAVLTree<E, P>{

	@Override
	public void add(E element, P parameter) {	 
		super.add(element, parameter);
		Node<E, P> added = search(parameter);
		balance(added);
	}

	@Override
	public Node<E, P> delete (E element, P parameter) {
		Node<E, P> parent = super.delete(element, parameter);
		balance(parent);
		return parent;
	}

	@Override
	public Node<E, P> leftRotate(Node<E, P> node) {
		Node<E, P> right = node.getRight();
		Node<E, P> subOfRight = right.getLeft();

		right.setLeft(node);
		node.setRight(subOfRight);
		
		//setting new relationships 
		right.setParent(node.getParent());
		if(node.getParent() != null){
			
			if(node.getParent().compareTo(right) < 0) {
				node.getParent().setRight(right);
			}else {
				node.getParent().setLeft(right);
			}
			
		}else {
			setRoot(right);
		}
		
		node.setParent(right);
		if(subOfRight != null){
			subOfRight.setParent(node);
		}
		
		return right;
	}

	@Override
	public Node<E, P> rightRotate(Node<E, P> node) {
		Node<E, P> left  = node.getLeft();
		Node<E, P> subOfLeft = left.getRight();
 
		left.setRight(node);
		node.setLeft(subOfLeft);
		
		//setting new relationships
		left.setParent(node.getParent());
		if(left.getParent() == null) {
			setRoot(left);
		}else {
			if(node.getParent().compareTo(left) < 0) {
				node.getParent().setRight(left);
			}else {
				node.getParent().setLeft(left);
			}
		}
		
		node.setParent(left);
		if(subOfLeft != null) {
			subOfLeft.setParent(node);
		}
		return left;
	}

	@Override
	public void balance(Node<E, P> node) {
		if(node != null) {
			int nodeBalance = getBalance(node);

			if(nodeBalance >= 2) {
				int previousNodeBalance = getBalance(node.getRight());

				if(previousNodeBalance < 0) {
					rightRotate(node.getRight());
				}
				leftRotate(node);
			}else if(nodeBalance <= -2){

				int previousNodeBalance = getBalance(node.getLeft());

				if(previousNodeBalance >= 0) {
					leftRotate(node.getLeft());
				}
				rightRotate(node);
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
