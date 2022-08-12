package ds.linkedlist;

import java.util.Stack;

public class ReverseLinkedList {

    private static Node reverse(Node head) {
        if (head == null){
            return null;
        }else if (head.next == null){
            return head;
        }
        Stack<Node> stack = new Stack<>();
        Node current = head;
        while(current != null){
            stack.push(current);
            current = current.next;
        }
//        Node temp = new Node(stack.pop().data);
//        Node copy = temp;
        Node temp = null;
        while (!stack.isEmpty()){
            if(temp == null){
                temp = new Node(stack.pop().data);
            }
            temp.next = stack.pop();
        }

        return temp;
    }
    public static void print(Node head){
        Node c = head;
        while (c != null){
            System.out.println(c.data);
            c = c.next;
        }
    }


    public static void main(String[] args) {
        Node node = new Node(1);
        node.next = new Node(2);
        node.next.next = new Node(3);
        node.next.next.next = new Node(4);
        node.next.next.next.next = new Node(5);
        //print(node);

        Node reverse = reverse(node);
        print(reverse);

    }

}
