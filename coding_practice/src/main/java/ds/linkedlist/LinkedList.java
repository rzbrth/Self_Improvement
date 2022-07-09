package ds.linkedlist;

public class LinkedList {

	private static class Node {
		private int data;
		private Node next;

		private Node(int data) {
			this.data = data;
		}
	}

	Node head;

	public void append(int data) {
		// if head null then create head
		if (head == null) {
			this.head = new Node(data);
			return;
		}
		// Take new pointer to point to head node
		// (Never loose pointer to head node)
		Node current = head;
		// scan till last element that's why started loop from current.next 
		while (current.next != null) {
			current = current.next;
		}
		// we have reached end of list add new element at the end
		current.next = new Node(data);

	}

	public void prepend(int data) {
		// if head null then create head
		if (head == null) {
			this.head = new Node(data);
			return;
		}
		// create new node
		Node newHead = new Node(data);
		// point newly created node to head node
		newHead.next = this.head;
		// make head point to newly created node
		head = newHead;
	}

	public void deleteNodeWithValue(int data) {

		// if head null, return  1 2 3
		if (head == null) {
			return;
		}
		// if data points to head node, then change head node
		if (head.data == data) {
			head = head.next;
			return;
		}
		// Take new pointer to point to head node
		// (Never loose pointer to head node)
		Node current = head;
		// scan till last element
		while (current.next != null) {
			// check if next node data same as input data , if so then delete
			if (current.next.data == data) {
				current = current.next.next;
				return;
			}
			current = current.next;
		}

	}

}
