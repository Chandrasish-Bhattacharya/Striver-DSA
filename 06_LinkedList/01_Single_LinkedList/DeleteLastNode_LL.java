class Node {
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
        this.next = null;
    }

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class DeleteLastNode_LL {
    public static void printLL(Node head) {
        while (head != null) {
            System.out.print(head.data);
            head = head.next;
        }
    }

    public static void leetCode(Node node) { // head will not be provided
        node.data = node.next.data;
        node.next = node.next.next;
    }

    public static Node delNode(Node head) {
        if (head == null || head.next == null)
            return null;
        Node present = head;
        Node curr = head.next;
        while (curr.next != null) {
            present = curr;
            curr = curr.next;
        }
        present.next = null;
        return head;
    }

    public static void main(String[] args) {
        int[] arr = { 2, 5, 8, 7 };
        // Create the linked list with nodes initialized with array values
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);
        head.next.next.next = new Node(arr[3]);
        // Delete the tail of the linked list
        head = delNode(head);
        // Print the modified linked list
        printLL(head);
    }
}
