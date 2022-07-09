package ds.linkedlist;

public class FindMiddleInLinkedList {
	 
	Node head;

	static Node findMiddle(Node head) {
		if (head == null) {
			throw new RuntimeException("Head can't be null");
		}
		if (head.next == null) {
			return head;
		}

		Node fast = head;
		Node slow = head;
		while (fast != null && fast.next != null) {
			fast = fast.next.next;
			slow = slow.next;
		}
		return slow;

	}

	public static void main(String[] args) {

		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);


		System.out.println(findMiddle(node).data);

	}
}
