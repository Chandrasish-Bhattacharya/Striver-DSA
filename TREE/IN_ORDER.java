package TREE;

public class IN_ORDER {
    class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }
    }
    public static void inOrder(Node node) {
        if (node == null) {
            return;
        }
        inOrder(node.left);
        System.out.print(node.data + " ");
        inOrder(node.right);
    }
    public static void main(String[] args) {
        IN_ORDER tree = new IN_ORDER();
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        inOrder(root);
    }

}
