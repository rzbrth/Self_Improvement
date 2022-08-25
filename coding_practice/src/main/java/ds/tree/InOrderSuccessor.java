package ds.tree;

public class InOrderSuccessor {

    public static Node getInOrderSucc(Node root, int data) {

        Node successor = null;

        while (root != null) {
            if (data >= root.data) {
                root = root.right;
            } else {
                successor = root;
                root = root.left;
            }

        }

        return successor;
    }




    public static void main(String[] args) {

        BinaryTree tree = new BinaryTree();
        Node root = new Node(6);
        tree.insertRec(5, root);
        tree.insertRec(15, root);
        tree.insertRec(8, root);
        tree.insertRec(6, root);
        Node result = InOrderSuccessor.getInOrderSucc(root, 5);
        System.out.println("Inorder successor is:->");
        System.out.println(result != null ? result.data : null);
    }

}
