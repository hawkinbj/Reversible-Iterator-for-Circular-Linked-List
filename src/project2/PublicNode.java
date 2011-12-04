package project2;

public class PublicNode<T> {
	// the element the node will hold
	public T element;

	// tracks the previous and next nodes
	public PublicNode<T> previous, next;

	public PublicNode(T element) {
		this.element = element;
		previous = next = null;
	}

}