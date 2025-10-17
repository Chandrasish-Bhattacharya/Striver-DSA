// Reverse a Doubly Linked List
// Problem Statement: Given a doubly linked list of size ‘N’ consisting of positive integers, your task is to reverse it and return the head of the modified doubly linked list.
// Example 1:
// Input Format:
// DLL: 1 <-> 2 <-> 3 <-> 4
// Result: DLL: 4 <-> 3 <-> 2 <-> 1
// Explanation: The doubly linked list is reversed and its last node is returned at the new head pointer.
// Example 2:
// Input Format:
// DLL: 10 <-> 20 <-> 30
// Result: DLL: 30 <-> 20 <-> 10

import java.util.Stack;

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

public class ReverseDLL {
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

    public static Node reverseDLL(Node head) {
        if (head == null || head.next == null) {
            return head;
        }
        Stack<Integer> st = new Stack<>();
        Node temp = head;
        while (temp != null) {
            st.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = st.pop();
            temp = temp.next;
        }
        return head;
    }

    // lets code the optimal sol 
   public static Node revOptimal(Node head) {
    if (head == null || head.next == null) {
        return head;
    }

    Node prev = null;
    Node current = head;

    while (current != null) {
        prev = current.prev;
        current.prev = current.next;
        current.next = prev;
        current = current.prev;
    }

    return prev.prev; // new head
}


    public static void main(String[] args) {
        int[] arr = {12, 5, 6, 8, 4};
        // Convert the array to a doubly linked list
        Node head = convertArr2DLL(arr);

        // Print the doubly linked list
        System.out.println("Doubly Linked List Initially:");
        print(head);

        System.out.println("Doubly Linked List After Reversing :");

        head = revOptimal(head);
        print(head);

    }
}
