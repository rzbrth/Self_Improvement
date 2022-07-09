package ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class FindLoopInLinkedList {

	Node head;

	public static boolean isLoopPresent(Node head) {

		if (head == null || head.next == null) {
			return false;
		}
		Node fast = head.next;
		Node slow = head;
		while (fast != null && fast.next != null & slow != null) {
			if (fast == slow) {
				return true;
			}
			fast = fast.next.next;
			slow = slow.next;

		}

		return false;
	}
	public static void main(String[] args) {

		// Create a head Node
		Node head = new Node(20);

		// Inserting Node in Linked List
		head.next = new Node(4);
		head.next.next = new Node(5);
		head.next.next.next = new Node(10);

		// Just to make a cycle
		head.next.next.next.next = head;

		if (isLoopPresent(head))
			System.out.print("Loop detected.");

		else
			System.out.print("No Loop Found.");

		System.out.println();
	}
}
