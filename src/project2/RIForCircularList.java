package project2;

import java.util.*;

public class RIForCircularList<T> implements ReversibleIterator<T> {
	private PublicNode<T> previousnode, currentnode, nextnode;
	private CircularList<T> list;

	// constructor takes a LinkedList
	public RIForCircularList(CircularList<T> list) {
		this.list = list;
		currentnode = previousnode = null;
		nextnode = list.getList().front;
	}

	// The remove operation is not supported.
	public void remove() {
		throw new UnsupportedOperationException();
	}

	// checks to see if there is a next element in the list
	// O(1)
	public boolean hasNext() {
		return nextnode != null;
	}

	// returns the next element in the list
	// O(1)
	public T next() {
		if (nextnode == null)
			throw new NoSuchElementException();
		currentnode = nextnode;
		previousnode = currentnode.previous;
		nextnode = currentnode.next;
		return currentnode.element;
	}

	// checks to see if there is a previous element in the list
	// O(1)
	public boolean hasPrevious() {
		return previousnode != null;
	}

	// returns the previous element in the list
	// O(1)
	public T previous() {
		if (previousnode == null)
			throw new NoSuchElementException();
		currentnode = previousnode;
		previousnode = currentnode.previous;
		nextnode = currentnode.next;
		return currentnode.element;
	}

}
