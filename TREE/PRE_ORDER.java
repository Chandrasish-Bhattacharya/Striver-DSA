package TREE;

public class PRE_ORDER {
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }
    }

    public static void preOrder(Node node) {
        if (node == null) {
            return;
        }
        System.out.print(node.data + " ");
        preOrder(node.left);
        preOrder(node.right);
    }

    public static void main(String[] args) {
        PRE_ORDER tree = new PRE_ORDER();
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        preOrder(root);
    }
}