package datastr;

import java.util.List;

public interface IBinaryTree<E, P> {

	public void add(E element);
	public void delete(E element);
	public E search(P parameter);
	public List<E> searchList(P parameter, Criteria criterion);
	public E getMinimum();
	public E getMaximum();
	public boolean isEmpty();
	
}
