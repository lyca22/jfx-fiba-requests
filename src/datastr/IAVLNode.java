package datastr;

public interface IAVLNode<E extends Comparable<E>, P extends Comparable<P>> extends INode<E, P>{
	
	public int getBalance();
	public int getHeight();
	
}
