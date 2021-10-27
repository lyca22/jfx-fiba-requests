package datastr;

public interface INode<E> {
	
	public E getSuccessor();
	public E getPredecessor();
	public int getHeight();
	
}
