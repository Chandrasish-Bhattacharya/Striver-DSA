// Find the Length of a Linked List
// Problem Statement: Given the head of a linked list, print the length of the linked list.
// Example 1:


// Input Format: 0->1->2

// Result: 3

// Explanation: The list has a total of 3 nodes, thus the length of the list is 3.
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
public class Length_LL {
    public static int FindLL(Node head){
        int count = 0;
        if(head == null) return 0;
        while(head!= null){
            count++;
            head = head.next;
        }
        return count;
    }
    public static void main(String[] args) {
        int[]arr={2,5,8,7};
        Node head = new Node(arr[0]);
        head.next= new Node(arr[1]);
        head.next.next= new Node(arr[2]);
        head.next.next.next= new Node(arr[3]);
        // Print the length of the linked list
        System.out.println(FindLL(head));
    }
}
