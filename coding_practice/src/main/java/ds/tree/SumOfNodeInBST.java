package ds.tree;

public class SumOfNodeInBST {

    static int sum =0;

    private static int addBT(Node root) {

        if (root == null){
            return 0;
        }
        return root.data + addBT(root.left) + addBT(root.right);
    }

    private static void addBTUsingInOrderTraversal(Node root) {

        if (root==null){
            return;
        }
        addBTUsingInOrderTraversal(root.left);
        sum = sum + root.data;
        addBTUsingInOrderTraversal(root.right);

    }


    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Node root = new Node(10);
        tree.insertRec(5,root);
        tree.insertRec(15,root);
        tree.insertRec(8,root);

        int sum = addBT(root);
        System.out.println("Sum of all the elements is: " + sum);

        addBTUsingInOrderTraversal(root);
        System.out.println("Sum of all the elements is: " + SumOfNodeInBST.sum);

    }


}
