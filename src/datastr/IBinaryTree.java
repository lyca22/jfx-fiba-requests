package datastr;

import java.util.List;

public interface IBinaryTree<E extends Comparable<E>, P extends Comparable<P>> {

	public void add(E element);
	public void delete(E element);
	public Node<E, P> search(P parameter);
	public List<E> searchList(P parameter, ComparisonCriteria criterion);
	public E getMinimum();
	public E getMaximum();
	public boolean isEmpty();

}
