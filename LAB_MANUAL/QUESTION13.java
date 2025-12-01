import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int data) {
        this.data = data;
        left = right = null;
    }
}

public class QUESTION13 {

    static int preorderIndex = 0;
    static Map<Integer, Integer> inorderMap = new HashMap<>();

    // Build Tree Function
    public static Node buildTree(int[] preorder, int[] inorder, int start, int end) {

        // No elements left
        if (start > end)
            return null;

        // Pick current node from preorder
        int rootValue = preorder[preorderIndex++];
        Node root = new Node(rootValue);

        // Leaf node check
        if (start == end)
            return root;

        // Find root position in inorder
        int inorderIndex = inorderMap.get(rootValue);

        // Build left and right subtrees
        root.left = buildTree(preorder, inorder, start, inorderIndex - 1);
        root.right = buildTree(preorder, inorder, inorderIndex + 1, end);

        return root;
    }

    // Print inorder (to verify)
    public static void printInorder(Node root) {
        if (root != null) {
            printInorder(root.left);
            System.out.print(root.data + " ");
            printInorder(root.right);
        }
    }

    public static void main(String[] args) {

        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        // Map inorder values for quick lookup
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }

        Node root = buildTree(preorder, inorder, 0, inorder.length - 1);

        System.out.println("Tree constructed. Inorder traversal of tree:");
        printInorder(root);
    }
}
