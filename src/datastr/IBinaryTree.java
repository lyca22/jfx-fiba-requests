package datastr;

import java.util.ArrayList;
import java.util.List;

public interface IBinaryTree<E, P extends Comparable<P>> {

	public void add(E element, P parameter);
	public Node<E, P> search(E element, P parameter);
	public Node<E, P> delete(E element, P parameter);
	public List<E> searchList(P parameter, ComparisonCriteria criterion);
	public ArrayList<E> getMinimum();
	public ArrayList<E> getMaximum();
	public boolean isEmpty();
	public String inorder();

}
