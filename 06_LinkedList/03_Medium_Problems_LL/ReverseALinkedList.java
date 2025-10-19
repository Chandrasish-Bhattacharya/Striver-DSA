// Reverse a LinkedList [Iterative]
// Problem Statement: Problem Statement: Given the head of a singly linked list, write a program to reverse the linked list, and return the head pointer to the reversed list.
// Example 1:
// Input Format:
// LL: 1   3   2   4 
// Output: 3
// Explanation: After reversing the linked list, the new head will point to the tail of the old linked list.
// Example 2:
// Input Format:
// LL: 4
// Output: 4

import java.util.Stack;

class Node {
    int data;
    Node next;

    public Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }

    public Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class ReverseALinkedList {
    public static Node usingStack(Node head) { // this can also be done using a array
        Node temp = head;
        Stack<Integer> s = new Stack<>();
        while (temp != null) {
            s.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            temp.data = s.pop();
            temp = temp.next;
        }
        return head;
    }

    public static Node OptimalPointer(Node head){
        Node temp = head;
        Node front = head;
        Node tail = null;
        while(temp!=null){
            front = temp.next;
            temp.next = tail;
            tail = temp;
            temp = front;
        }
        return tail;
    }

    public static Node OptimalRecursive(Node head){
        
        if(head == null || head.next == null){
            return head;
        }
        Node newHead = OptimalPointer(head);
        Node front = head.next;
        front.next = head;
        head.next = null;
        return newHead;
    }

    public static void printLinkedList(Node head) {
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        // Create a linked list with values 1, 3, 2, and 4
        Node head = new Node(1);
        head.next = new Node(3);
        head.next.next = new Node(2);
        head.next.next.next = new Node(4);

        // Print the original linked list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Reverse the linked list
        head = OptimalPointer(head);

        // Print the reversed linked list
        System.out.print("Reversed Linked List: ");
        printLinkedList(head);
    }
}
