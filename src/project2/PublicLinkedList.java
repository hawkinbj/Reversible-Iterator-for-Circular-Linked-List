package project2;

public class PublicLinkedList<T> {
	// the front and the back of the list
	public PublicNode<T> front, back;

	// construct an empty linked list
	PublicLinkedList() {
		front = back = null;
	}
}
