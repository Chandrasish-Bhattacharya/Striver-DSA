// Delete the Middle Node of the Linked List
// Problem Statement: Given the head of a linked list of integers, delete the middle node of the linked list and return the modified head. However, if the linked list has an even number of nodes, delete the second middle node.
// Input: 1->2->3->4->5 
// Output: 1->2->4->5
// Explanation: Node with value 3 is at the middle node and deleted.
// Input: 1->2->3->4
// Output: 1->2->4
class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class DeletetheMiddleNode {
    public static Node RemoveMid(Node head) {
        if (head == null || head.next == null) {
            return null;
        }
        Node prev = null, slow = head, fast = head;
        while (slow != null && fast != null && fast.next != null) {
            fast = fast.next.next;
            prev = slow;
            slow = slow.next;
        }
        prev.next = slow.next;
        return head;
    }

    public static void printLL(Node head) {
        // Initialize a temporary pointer
        Node temp = head;
        // Traverse the linked list and print data
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        // Print a newline after the list
        System.out.println();
    }

    public static void main(String[] args) {
        // Creating a sample linked list
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Display the original linked list
        System.out.print("Original Linked List: ");
        printLL(head);

        // Deleting the middle node
        head = RemoveMid(head);

        // Displaying the updated linked list
        System.out.print("Updated Linked List: ");
        printLL(head);
    }
}
