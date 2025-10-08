// Delete Last Node of a Doubly Linked List
// Problem Statement: Given a Doubly Linked List. Delete the last of a Doubly Linked List.
// Examples
// Example 1: DLL: 1 <-> 3 <-> 4 <-> 1
// Result: DLL: 1 <-> 3 <-> 4
// Explanation: After deleting the tail node we will get a doubly linked list. The node at the end of the doubly linked list will no longer be a part of it.
// Input Format: DLL: 7 <-> 5
// Result: DLL: 7
// Explanation: 7 will be the only node left after we delete the tail node of the doubly linked list.
class Node {
    Node prev;
    int data;
    Node next;

    public Node(int data) {
        this.data = data;
    }

    public Node(int data, Node prev, Node next) {
        this.data = data;
        this.prev = prev;
        this.next = next;
    }
}

public class DeleteLastNode {

    public static Node sol(Node head) {
        if (head == null)
            return null;

        if (head.next == null) {
            return null;
        }

        Node temp = head;

        while (temp.next.next != null) {
            temp = temp.next;
        }

        temp.next.prev = null;
        temp.next = null;

        return head;
    }

    private static Node convertArr2DLL(int[] arr) {
        Node head = new Node(arr[0]);
        Node prev = head;

        for (int i = 1; i < arr.length; i++) {
            Node temp = new Node(arr[i], prev, null);
            prev.next = temp;
            prev = temp;
        }
        return head;
    }

    private static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        int[] arr = { 12, 5, 6, 8 };
        Node head = convertArr2DLL(arr);
        print(head);

        System.out.println("Doubly Linked List after deleting tail node: ");
        head = sol(head);
        print(head);
    }
}
