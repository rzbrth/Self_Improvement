package ds.queue;

public class Queue {

	private static class Node {

		private int data;
		private Node next;

		private Node(int data) {
			this.data = data;

		}
	}

	private Node head; // Remove from head

	private Node tail; // Add to tail

	public boolean isEmpty() {
		return head == null;
	}

	public int peek() {
		if(head == null) {
			throw new RuntimeException("Head is null");
		}
		return head.data; // may throw exception. Head null check required 
	}

	public void add(int data) {
		Node node = new Node(data);
		if (tail != null) {
			tail.next = node;
		}
		tail = node;// now change tail position
		if (head == null) {
			head = node;
		}
	}

	public int remove() {
		int data = 0;
		if (head == null) {
			tail = null;
		} else {
			data = head.data;
			head = head.next;
		}
		return data;

	}
}
