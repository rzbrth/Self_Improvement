package ds.tree;

import java.util.HashMap;
import java.util.Map;
/*
 https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/
 https://leetcode.com/problems/construct-binary-tree-from-inorder-and-postorder-traversal/
 */
public class ConstructTree {


    public Node buildTreeFromInAndPost(int[] inOrder, int[] postOrder) {

        if (inOrder == null || postOrder == null || inOrder.length != postOrder.length) {
            return null;
        }

        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }

        return buildTreePostIn(inOrder, 0, inOrder.length - 1, postOrder,
                0, postOrder.length - 1, inOrderMap);
    }

    private Node buildTreePostIn(int[] inOrder, int inOrderStart, int inOrderEnd, int[] postOrder,
                                 int postOrderStart, int postOrderEnd, Map<Integer, Integer> inOrderMap) {

        if (inOrderStart > inOrderEnd || postOrderStart > postOrderEnd) {
            return null;
        }

        Node root = new Node(postOrder[postOrderEnd]);

        int inOrderRootIndex = inOrderMap.get(root.data);

        int inorderNumToLeft = inOrderRootIndex - inOrderStart;


        root.left = buildTreePostIn(inOrder, inOrderStart, inOrderRootIndex - 1, postOrder,
                postOrderStart, postOrderStart + inorderNumToLeft - 1, inOrderMap);

        root.right = buildTreePostIn(inOrder, inOrderRootIndex + 1, inOrderEnd, postOrder,
                postOrderStart + inorderNumToLeft, postOrderEnd - 1, inOrderMap);
        return root;
    }

    private Node buildTreeFromInAndPre(int[] inOrder, int[] preOrder) {
        if (inOrder == null || preOrder == null || inOrder.length != preOrder.length) {
            return null;
        }

        Map<Integer, Integer> inOrderMap = new HashMap<>();

        for (int i = 0; i < inOrder.length; i++) {
            inOrderMap.put(inOrder[i], i);
        }

        return buildTreePreIn(inOrder, 0, inOrder.length - 1, preOrder, 0, preOrder.length - 1, inOrderMap);
    }

    private Node buildTreePreIn(int[] inOrder, int inOrderStart, int inOrderEnd, int[] preOrder,
                                int preOrderStart, int preOrderEnd, Map<Integer, Integer> inOrderMap) {

        if (inOrderStart > inOrderEnd || preOrderStart > preOrderEnd) {
            return null;
        }
        Node root = new Node(preOrder[preOrderStart]);
        int inOrderRootIndex = inOrderMap.get(root.data);
        int inorderNumToLeft = inOrderRootIndex - inOrderStart;

        root.left = buildTreePreIn(inOrder, inOrderStart, inOrderRootIndex - 1, preOrder,
                preOrderStart + 1, preOrderStart + 1 + inorderNumToLeft - 1, inOrderMap);

        root.right = buildTreePreIn(inOrder, inOrderRootIndex + 1, inOrderEnd, preOrder,
                preOrderStart + 1 + inorderNumToLeft - 1 + 1, preOrderEnd, inOrderMap);
        return root;
    }

    public static void main(String[] args) {
        int[] inOrder = {9, 3, 15, 20, 7};
        int[] postOrder = {9, 15, 7, 20, 3};
        int[] preOrder = {3, 9, 20, 15, 7};
        ConstructTree tree = new ConstructTree();
        Node root = tree.buildTreeFromInAndPost(inOrder, postOrder);
        BinaryTree bst = new BinaryTree();
        System.out.println("Printing inorder");
        bst.printInOrder(root);
        System.out.println("Printing postorder");
        bst.printPostOrder(root);

        Node root2 = tree.buildTreeFromInAndPre(inOrder, preOrder);
        System.out.println("Printing inorder");
        bst.printInOrder(root2);
        System.out.println("Printing preorder");
        bst.printPreOrder(root2);

    }


}
