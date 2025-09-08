package TREE;

public class POST_ORDER {
     class Node {
        int data;
        Node left, right;

        public Node(int item) {
            data = item;
        }
    }
    public static void postOrder(Node node) {
        if (node == null) {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.print(node.data + " ");
    }
    public static void main(String[] args) {
        POST_ORDER tree = new POST_ORDER();
        Node root = tree.new Node(1);
        root.left = tree.new Node(2);
        root.right = tree.new Node(3);
        postOrder(root);
    }
}
