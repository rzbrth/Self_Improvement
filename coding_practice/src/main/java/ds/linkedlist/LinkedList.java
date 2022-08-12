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

    public LinkedList(Node head) {
        this.head = head;
    }

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
        while (current != null && current.next != null) {
            // check if next node data same as input data , if so then delete
            if (current.next.data == data) {
                current.next = current.next.next;
                continue;
            }
            current = current.next;
        }
        //print(head);
    }

    public void print(Node root){
        if (root == null){
            return;
        }
        Node current = root;
        while (current != null){
            System.out.println(current.data);
            current = current.next;
        }
    }
    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        LinkedList linkedList = new LinkedList(node);
        linkedList.append(11);
        linkedList.print(node);
        linkedList.deleteNodeWithValue(11);
        linkedList.print(node);
    }

}
