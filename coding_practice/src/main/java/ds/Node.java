package ds;

// BST implementation
public class Node {
	private int data;
	private Node left, right;

	private Node(int data) {
		this.data = data;
		this.left = null;
		this.right = null;
	}

	public void insert(int value) {

		if (value <= data) {
			if (left == null) {
				left = new Node(value);
			} else {
				left.insert(value);
			}
		} else {
			if (right == null) {
				right = new Node(value);
			} else {
				right.insert(value);
			}
		}

	}

	public boolean contains(int value) {

		if (value == data) {
			return true;
		} else if (value < data) {
			if (left == null) {
				return false;
			} else {
				return left.contains(value);
			}
		} else {
			if (right == null) {
				return false;
			} else {
				return right.contains(value);
			}
		}

	}

	public void printInOrder() {
		if (left != null) {
			left.printInOrder();
		}
		System.out.println(data);
		if (right != null) {
			right.printInOrder();
		}
	}

	public void printPreOrder() {
		System.out.println(data);

		if (left != null) {
			left.printInOrder();
		}

		if (right != null) {
			right.printInOrder();
		}
	}

	public void printPostOrder() {
		if (left != null) {
			left.printInOrder();
		}

		if (right != null) {
			right.printInOrder();
		}

		System.out.println(data);
	}

	/*
	 * Check if BST is balanced or not 
	 * BST can't have duplicate 
	 * Inclusive range
	 */
	public boolean checkBST(Node root) {
		return checkBST(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
	}

	public boolean checkBST(Node root, int minValue, int maxValue) {

		if (root == null) {
			return true;
		} else if (root.data < minValue || root.data > maxValue) {
			return false;
		}

		return checkBST(root.left, minValue, root.data - 1)
				&& checkBST(root.right, root.data + 1, maxValue);
	}
	
	public void printLeafNode(Node root) {
		
		// If node is null, return
		if(root == null) {
			return;
		}
		// If node is leaf node, print its data  
		if(root.left == null && root.right == null) {
			System.out.println(root.data);
			return;
		}
		// If left child exists, check for leaf
	    // recursively
		if(root.left != null) {
			printLeafNode(root.left);
		}
		 // If right child exists, check for leaf
	    // recursively
		if(root.right!= null) {
			printLeafNode(root.right);
		}
	}

	public static void main(String args[]) {

		Node root = new Node(10);
		root.left = new Node(5);
		root.right = new Node(15);

		System.out.println(root.contains(20));
		System.out.println(root.contains(15));

		root.insert(30);
		root.insert(1);
		// root.insert(10);

		root.printInOrder();
		root.printPreOrder();
		root.printPostOrder();

		System.out.println(root.checkBST(root));
		root.printLeafNode(root);
	}
}
