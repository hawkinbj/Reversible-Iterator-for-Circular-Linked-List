package project2;

import java.util.NoSuchElementException;

public class CircularLinkedList<T> implements CircularList<T> {
	private PublicLinkedList<T> list;
	private int size;

	public CircularLinkedList() {
		list = new PublicLinkedList<T>();
		size = 0;
	}

	// provides access to internal list
	public PublicLinkedList<T> getList() {
		return list;
	}

	// add elt to the end of the list
	// O(1)
	public void add(T elt) {
		PublicNode<T> newnode = new PublicNode<T>(elt);
		if (size == 0) {
			list.front = list.back = newnode;
			list.front.previous = list.back;
			list.back.next = list.front;

		} else {
			list.back.next = newnode;
			newnode.previous = list.back;
			newnode.next = list.front;
			list.front.previous = newnode;
			list.back = newnode;
		}
		size++;
	}

	// remove one copy of elt from the list
	// O(n)
	public boolean remove(T elt) {
		if (this.size > 0) {
			PublicNode<T> current = list.front;
			if (size == 1) {
				if (current.element.equals(elt)) {
					list.front = list.back = null;
					size--;
					return true;
				} else
					return false;
			} else {
				for (int i = 0; i < size; i++) {
					if (current.element.equals(elt)) {
						current.previous.next = current.next;
						current.next.previous = current.previous;
						if (current == list.front) {
							list.front = current.next;
						}
						if (current == list.back) {
							list.back = current.previous;
						}
						size--;
						return true;
					} else
						current = current.next;
				}
			}
		}
		return false;
	}

	// Size of the list
	// O(1)
	public int size() {
		return size;
	}

	// Helper method to return node of particular elt
	// O(n)
	private PublicNode<T> find(T elt) {
		if (size < 1) {
			throw new NoSuchElementException();
		}
		PublicNode<T> current = list.front;
		for (int i = 0; i < size; i++) {
			if (current.element.equals(elt)) {
				return current;
			} else
				current = current.next;
		}
		return null;
	}

	// returns true if elt is in the list
	// O(n)
	public boolean contains(T elt) {
		if (size < 1)
			return false;
		if (this.find(elt) != null)
			return true;
		return false;
	}

	// set elt to be front of the list
	// O(n)
	public void setFront(T elt) {
		PublicNode<T> temp = this.find(elt);
		if (temp == null || size < 1) {
			throw new NoSuchElementException();
		}
		list.front = temp;
		list.back = list.front.previous;
	}

	// Reservible Iterator to go through the list
	// O(1)
	public ReversibleIterator<T> iterator() {
		return new RIForCircularList(this);
	}

}
