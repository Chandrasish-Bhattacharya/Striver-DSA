// Check if the given Linked List is Palindrome
// Example 1:
// Input Format:
// LL: 1  2  3  2  1
// Output: True
// Explanation: A linked list with values "1 2 3 2 1" is a palindrome because its elements read the same from left to right and from right to left, making it symmetrical and mirroring itself.
// Example 2:
// Input Format:
// LL: 1 2 3 3 2 1 
// Output: True
// Explanation: A linked list with values "1 2 3 3 2 1" is a palindrome because it reads the same forwards and backwards.
// Example 3:
// Input Format:
// LL: 1 2 3 2 3
// Output: False
// Explanation: The linked list "1 2 3 2 3" is not a palindrome because it reads differently in reverse order, where "3 2 3 2 1" is not the same as the original sequence "1 2 3 2 3."

import java.util.Stack;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }

    Node(int data, Node next) {
        this.data = data;
        this.next = next;
    }
}

public class Palindrome {
    public static boolean bruteForce(Node head) { // simple using the stack
        Node temp = head;
        Stack<Integer> stack = new Stack<>();
        while (temp != null) {
            stack.push(temp.data);
            temp = temp.next;
        }
        temp = head;
        while (temp != null) {
            if (stack.peek() != temp.data)
                return false;
            stack.pop();
            temp = temp.next;
        }
        return true;
    }

    public static Node OptimalPointer(Node head) {
        Node temp = head;
        Node front = head;
        Node tail = null;
        while (temp != null) {
            front = temp.next;
            temp.next = tail;
            tail = temp;
            temp = front;
        }
        return tail;
    }

    public static boolean optimalSol(Node head){
        Node rabbit = head , hare = head;
        while(rabbit != null && rabbit.next != null){
            rabbit = rabbit.next.next;
            hare = hare.next;
        }
        Node newHead = OptimalPointer(hare);
        Node temp = head;
        Node temp1 = newHead;
        while(temp1 != null){
            if(temp.data!=temp1.data){
            OptimalPointer(newHead);
            return false;
        }
        temp = temp.next;
        temp1 = temp1.next;
        }
        OptimalPointer(newHead);
        return true;
    }
 public static void main(String[] args) {
        // Create a linked list with
        // values 1, 5, 2, 5, and 1 (15251, a palindrome)
        Node head = new Node(1);
        head.next = new Node(5);
        head.next.next = new Node(2);
        head.next.next.next = new Node(5);
        head.next.next.next.next = new Node(1);
        
        // Check if the linked list is a palindrome
        if (optimalSol(head)) {
            System.out.println("The linked list is a palindrome.");
        } else {
            System.out.println("The linked list is not a palindrome.");
        }
    }
}
