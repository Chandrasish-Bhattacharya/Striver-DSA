class Node {
    Node prev;
    int data;
    Node next;

    public Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}

public class Insert_atEnd {
    // Function to insert a node at the end
    public static Node addToEnd(int data, Node head) {
        Node newNode = new Node(data);
        if (head == null)
            return newNode;

        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        // Insert at the end
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }

    // Convert array to doubly linked list
    private static Node convertArr2DLL(int[] arr) {
        if (arr.length == 0) return null;

        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], prev, null); // Corrected constructor usage
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    // Print the doubly linked list
    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 4};
        Node head = convertArr2DLL(arr);

        System.out.println("Doubly Linked List Initially:");
        print(head);

        head = addToEnd(10, head); // Insert at the end

        System.out.println("Doubly Linked List After Inserting at the end with value 10:");
        print(head);
    }
}
