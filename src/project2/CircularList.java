package project2;

public interface CircularList<T> extends Iterable<T> {
	public void add(T elt); // add elt to the end of the list

	public boolean remove(T elt); // remove one copy of elt from the list

	public int size(); // return the size of the list

	public boolean contains(T elt); // returns true if elt is in the list

	public void setFront(T elt); // set elt to be front of the list

	public ReversibleIterator<T> iterator(); // move forward and back through
												// list

	public String toString(); // return a description of the list

	public PublicLinkedList<T> getList(); //accesses the private LinkedList
}
