package ds.tree;

public class BST {

	private static class Node {

		Node left, right;

		int data;

		public Node(int data) {
			this.data = data;
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
			if (data == value) {
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

		public void printInOrder() {// left, root, right

			if (left != null) {
				left.printInOrder();
			}
			System.out.println(data);

			if (right != null) {
				right.printInOrder();
			}

		}

		public void printPreOrder() {// root, left, right

			System.out.println(data);

			if (left != null) {
				left.printInOrder();
			}

			if (right != null) {
				right.printInOrder();
			}

		}

		public void printPostOrder() {// left, right, root

			if (left != null) {
				left.printInOrder();
			}

			if (right != null) {
				right.printInOrder();
			}

			System.out.println(data);

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



	}
