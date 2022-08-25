package ds.tree;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

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

    public void printLevelOrder(Node node) {
        if (node == null) {
            return;
        }

        Queue<Node> queue = new ArrayDeque<>();
        queue.add(node);
        while (!queue.isEmpty()) {
            int count = queue.size();
            for (int i = 0; i < count; i++) {
                node = queue.remove();
                System.out.println(node.data + " ");
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }

            }
        }
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

    public int getLeafCount(Node node) {

        if (node == null) {
            return 0;
        } else if (node.left == null && node.right == null) {
            return 1;
        } else {
            return getLeafCount(node.left) + getLeafCount(node.right);
        }

    }

    public static int sum(Node node) {
        if (node == null) {
            return 0;
        }
        return node.data + sum(node.left) + sum(node.right);
    }

    public static int size(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + size(node.left) + size(node.right);
    }

    public static int max(Node node) {
        if (node == null) {
            return Integer.MIN_VALUE;
        }
        int leftMax = max(node.left);
        int rightMax = max(node.right);
        return Math.max(node.data, Math.max(leftMax, rightMax));
    }

    public static int heightOfEdges(Node node) {
        if (node == null) {
            return -1; // -1 for edge , 0 for node
        }
        int leftHeight = heightOfEdges(node.left);
        int rightHeight = heightOfEdges(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
    }

    public static int heightOfNodes(Node node) {
        if (node == null) {
            return 0; // 1 for edge , 0 for node
        }
        int leftHeight = heightOfNodes(node.left);
        int rightHeight = heightOfNodes(node.right);
        return 1 + Math.max(leftHeight, rightHeight);
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

    public Node remove(Node node, int data) {

        if (node == null) {
            return null;
        }
        if (data > node.data) {
            node.right = remove(node.right, data);
        } else if (data < node.data) {
            node.left = remove(node.left, data);
        } else {
            // data == node.data
            if (node.left != null && node.right != null) {
                // find max element among left child
                // replace node with the left max
                // delete left max from left subtree
                int leftMax = leftMax(node.left);
                node.data = leftMax;
                node.left = remove(node.left, leftMax);

            } else if (node.left != null) {
                return node.left;
            } else if (node.right != null) {
                return node.right;
            } else {
                return null;
            }
        }
        return node;
    }

    private static int leftMax(Node node) {

        if (node.right != null) {
            return node.right.data;
        } else {
            return node.data;
        }
    }

    static Node predecessor;
    static Node successor;
    static int state;

    //10,5,3,8,15
    public static void predecessorAndSuccessor(Node node, int data) {

        if (node == null) {
            return;
        }
        if (state == 0) {
            if (node.data == data) {
                state = 1;
            } else {
                predecessor = node;
            }
        } else if (state == 1) {
            successor = node;
            state = 2;
        }
        predecessorAndSuccessor(node.left, data);
        predecessorAndSuccessor(node.right, data);
    }

    public static void main(String[] args) {
        BinaryTree tree = new BinaryTree();
        Node root = new Node(10);
        tree.insertRec(5, root);
        tree.insertRec(15, root);
        tree.insertRec(8, root);
        tree.insertRec(3, root);

        System.out.println(BinaryTree.heightOfEdges(root));
        System.out.println(BinaryTree.heightOfNodes(root));

        BinaryTree.predecessorAndSuccessor(root, 10);
        System.out.println("predecessor");
        System.out.println(BinaryTree.predecessor != null ? BinaryTree.predecessor.data : null);
        System.out.println("successor");
        System.out.println(BinaryTree.successor != null ? BinaryTree.successor.data : null);

        System.out.println("Is balanced : " + tree.checkBST(root));
        System.out.println("\nInorder traversal of binary tree is ");
        tree.printInOrder(root);
        System.out.println("\nPostorder traversal of binary tree is ");
        tree.printPostOrder(root);
        System.out.println("Preorder traversal of binary tree is ");
        tree.printPreOrder(root);
        System.out.println("Level order traversal of binary tree is ");
        tree.printLevelOrder(root);

        tree.remove(root, 5);
        tree.printPreOrder(root);

        System.out.println("Searching for node with data 15: isFound-" + tree.containsRec(15, root));

        System.out.println("Is balanced  : " + tree.checkBST(root));

        Node node = tree.balanceBST(root);
        System.out.println("Is balanced after balancing : " + tree.checkBST(node));

        tree.reverseBST(root);
        System.out.println("Is balanced after reversal: " + tree.checkBST(root));
    }
}

