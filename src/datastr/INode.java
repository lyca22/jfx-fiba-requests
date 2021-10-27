package datastr;

public interface INode<E extends Comparable<E>, P extends Comparable<P>> {
	
	public Node<E, P> getSuccessor();
	public Node<E, P> getPredecessor();
	
}
