package ds.linkedlist;

import java.util.HashMap;
import java.util.Map;

public class DuplicateInLinkedList {
	 
	Node head;

	static void findDuplicate(Node head) {
		
		Map<Integer, Integer> duplicate = new HashMap<>();
		
		if (head == null) {
			throw new RuntimeException("Head can't be null");
		}
		if (head.next == null) {
			System.out.println("Only head present");
			return;
		}
		Node current = head;
		while(current != null) {
			System.out.println(current.data);
			duplicate.put(current.data, duplicate.getOrDefault(current.data, 0)+1);
			current = current.next;
		}
		for(Map.Entry<Integer, Integer> data : duplicate.entrySet()) {
			if(data.getValue() > 1) {
				System.out.println("Duplicate node are ="+data.getKey());
			}
		}
		
	}

	public static void main(String[] args) {

		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(3);
		node.next.next.next.next = new Node(2);
		
		findDuplicate(node);

	}
}
