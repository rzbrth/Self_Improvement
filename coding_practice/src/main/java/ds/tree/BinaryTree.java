package ds.tree;

import java.util.LinkedList;
import java.util.List;

public class BinaryTree {

    public Node insertRec(int value, Node root) {

        if (root == null) {
            return new Node(value);
        }
        if (value <= root.data) {
            root.left = insertRec(value, root.left);
        } else {
            root.right = insertRec(value, root.right);
        }
        return root;
    }

    public boolean containsRec(int value, Node root) {
        if (root == null) {
            return false;
        }
        if (root.data == value) {
            return true;
        } else if (value < root.data) {
            return containsRec(value, root.left);
        } else {
            return containsRec(value, root.right);
        }
    }

    public Node searchRec(Node root, int value) {

        if (root == null || root.data == value) {
            return root;
        } else if (value < root.data) {
            root.left = searchRec(root.left, value);
        } else {
            root.right = searchRec(root.right, value);
        }

        return root;
    }

    public void printInOrder(Node node) {// left, root, right

        if (node == null) {
            return;
        }
        printInOrder(node.left);
        System.out.println(node.data + " ");
        printInOrder(node.right);

    }

    public void printPreOrder(Node node) {// root, left, right

        if (node == null) {
            return;
        }
        System.out.println(node.data + " ");
        printPreOrder(node.left);
        printPreOrder(node.right);

    }

    public void printPostOrder(Node node) {// left, right, root

        if (node == null) {
            return;
        }
        printPostOrder(node.left);
        printPostOrder(node.right);
        System.out.println(node.data + " ");
    }

    public boolean checkBST(Node root) {
        return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    public boolean checkBST(Node root, int min, int max) {

        if (root == null) {
            return true;
        }
        if (root.data < min || root.data > max) {
            return false;
        }
        return checkBST(root.left, min, root.data - 1) && checkBST(root.right, root.data + 1, max);
    }

    public void reverseBST(Node root) {

        if (root == null) {
            return;
        }
        Node temp = root.left;
        root.left = root.right;
        root.right = temp;

        reverseBST(root.left);

        reverseBST(root.right);
    }


    private int getLeafCount(Node node) {

        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return getLeafCount(node.left) + getLeafCount(node.right);
        }

    }

    public Node balanceBST(Node root) {
        List<Integer> arr = new LinkedList<>();
        sortInorder(root, arr);
        //Collections.sort(arr);
        return sortedArrayToBST(arr, 0, arr.size() - 1);
    }

    public void sortInorder(Node node, List<Integer> arr) {
        if (node != null) {
            sortInorder(node.left, arr);
            arr.add(node.data);
            sortInorder(node.right, arr);
        }
    }

    public Node sortedArrayToBST(List<Integer> sortedArray, int start, int end) {

        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;

        Node root = new Node(sortedArray.get(mid));
        root.left = sortedArrayToBST(sortedArray, start, mid - 1);
        root.right = sortedArrayToBST(sortedArray, mid + 1, end);
        return root;
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(10);
        tree.insertRec(5, root);
        tree.insertRec(15, root);
        tree.insertRec(8, root);


        System.out.println("Is balanced : " + tree.checkBST(root));
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInOrder(root);
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder(root);
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder(root);

        System.out.println("Searching for node with data 15: isFound-" + tree.containsRec(15, root));

        System.out.println("Is balanced  : " + tree.checkBST(root));

        Node node = tree.balanceBST(root);
        System.out.println("Is balanced after balancing : " + tree.checkBST(node));

        tree.reverseBST(root);
        System.out.println("Is balanced after reversal: " + tree.checkBST(root));

    }
}

