// Add 1 to a number represented by LL
// Problem Statement: Given the head of a singly linked list representing a positive integer number. Each node of the linked list represents a digit of the number, with the 1st node containing the leftmost digit of the number and so on. The task is to add one to the value represented by the linked list and return the head of a linked list containing the final value.

// The number will contain no leading zeroes except when the value represented is zero itself.
// Input: 4->5->6
// Output: 4->5->7
// Explanation: 456 + 1 = 457
// Input: 9->9->9
// Output: 1->0->0->0
// Explanation: 999 + 1 = 1000
class Node {

    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class ADD1 {

    Node reverseLL(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node nextNode = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }

    Node addOne(Node head) {
        head = reverseLL(head);
        Node curr = head;
        int carry = 1;

        while (curr != null && carry > 0) {
            int sum = curr.val + carry;
            curr.val = sum % 10;
            carry = sum / 10;
            if (curr.next == null && carry > 0) {
                curr.next = new Node(carry);
                carry = 0;
            }
            curr = curr.next;
        }
        head = reverseLL(head);
        return head;
    }

    void printList(Node head) {
        Node current = head;
        while (current != null) {
            System.out.print(current.val);
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Node head = new Node(7);
        head.next = new Node(7);
        head.next.next = new Node(9);
        // head.next.next.next = new Node(0);
        // head.next.next.next.next = new Node(0);
        ADD1 sol = new ADD1();
        System.out.print("Previous Linked List: ");
        sol.printList(head);
        head = sol.addOne(head);

        System.out.print("Now Linked List: ");
        sol.printList(head);
    }
}
