// Remove N-th node from the end of a Linked List
// Problem Statement: Given a linked list and an integer N, the task is to delete the Nth node from the end of the linked list and print the updated linked list.
// Input:  5->1->2, N=2
// Output: 5->2
// Explanation: The 2nd node from the end of the linked list is 1. Therefore, we get this result after removing 1 from the linked list.
// Input:  1->2->3->4->5, N=3
// Output: 1->2->4->5
// Explanation: The 3rd node from the end is 3, therefore, we remove 3 from the linked list.

import java.util.Arrays;
import java.util.List;

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

public class RemoveNthNode {
    public static Node EndsNthNode(Node head , int n){
        if(head == null) return head;
        Node temp = head;
        int size = 0;
        while(temp!=null){
            size++;
            temp = temp.next;
        }
        if(n == size) return head.next;
        int idx = size - n;
        temp = head;
        while(temp!=null){
            idx --;
            if(idx == 0) break;
            temp = temp.next;
        }
        temp.next = temp.next.next;
        return head;
    }
    public static void printLL(Node head){
        Node temp = head;
        while(temp!=null){
            System.out.print(temp.val);
            temp = temp.next;
        }
    }

    // Optimal Solution 
    public static Node NthfromEnd(Node head , int n){
        if(head == null || head.next == null) return null;
        Node fast = head , slow = head;
        for(int i =0 ; i<=n; i++){
            fast = fast.next;
        }
        while(fast!=null){
            slow=slow.next;
            fast = fast.next;
        }
        slow.next = slow.next.next;
        return head;
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(1, 2, 3, 4, 5);
        int N = 3;

        // Create linked list manually
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));
        head.next.next.next.next = new Node(arr.get(4));

        // Delete the Nth node from the end
        head = NthfromEnd(head, N);

        // Print the modified linked list
        printLL(head);
    }
}
