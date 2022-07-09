package ds.stack;

/*
 * push() : Insert a new element into stack i.e inserting a new element at the beginning
   pop() : Return top element of the Stack i.e deleting the first element from the stack.
   peek(): Return the top element.
 */
public class Stack<T> {

	private static class Node<T> {
		private T data;
		private Node<T> prev;

		private Node(T data) {
			this.data = data;
		}
	}

	private Node<T> top; // add remove from top

	private int size = 0;

	public boolean isEmpty() {
		return top == null;
	}

	public T peek() {
		if (top == null) {
			throw new RuntimeException("top is null");
		}
		return top.data; // may throw exception
	}

	public void push(T data) {
		Node<T> node = new Node<T>(data);

		if (isEmpty()) {
			top = node;
		} else {
			node.prev = top;
			top = node;
		}
		size++;
	}

	public T pop() {
		if (top == null) {
			return null;
		}
		T data = top.data;
		top = top.prev;
		size--;

		return data;

	}

	public int size() {
		return size;
	}
}
