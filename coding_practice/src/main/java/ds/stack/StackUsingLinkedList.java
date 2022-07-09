package ds.stack;

public class StackUsingLinkedList {

	private static class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
		}
	}

	Node head;

	public void push(int data) {
		if (head == null) {
			head = new Node(data);
			return;
		}
		Node node = new Node(data);

		node.next = head;
		head = node;
	}

	public boolean isEmpty() {
		return head == null;
	}

	public int peek() {

		if (head == null) {
			System.out.printf("\nStack Underflow");
			return -1;
		}
		
		return head.data;

	}
	
	public int pop() {
		if (head == null) {
			System.out.printf("\nStack Underflow");
			return -1;
		}
		int data = head.data;
		head = head.next;
		return data;
	}
	
	public void display() {
		if (head == null) {
			System.out.printf("\nStack Underflow");
		}
		Node current = head;
		while(current != null) {
			// print node data
            System.out.printf("%d->", current.data);
            current = current.next;
		}
	}
	
	public static void main(String[] args)
    {
        // create Object of Implementing class
		StackUsingLinkedList obj = new StackUsingLinkedList();
        // insert Stack value
        obj.push(11);
        obj.push(22);
        obj.push(33);
        obj.push(44);
 
        // print Stack elements
        obj.display();
 
        // print Top element of Stack
        System.out.printf("\nTop element is %d\n", obj.peek());
 
        // Delete top element of Stack
        obj.pop();
        obj.pop();
 
        // print Stack elements
        obj.display();
 
        // print Top element of Stack
        System.out.printf("\nTop element is %d\n", obj.peek());
    }
}
