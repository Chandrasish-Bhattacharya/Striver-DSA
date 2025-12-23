// Sort a Linked List
// Problem Statement: Given a linked list, sort its nodes based on the data value in them. Return the head of the sorted linked list.
// Input: 3->4->2->1->5 
// Output: 1->2->3->4->5
// Explanation: The input linked list when sorted from [3, 4, 2, 1, 5] results in a linked list with values [1, 2, 3, 4, 5].
// Input: 40->20->60->10->50->30
// Output: 10->20->30->40->50->60
// Explanation: The input linked list when sorted from [40, 20, 60, 10, 50, 30] results in a linked list with values [10, 20, 30, 40, 50, 60].
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class ListNode{
    int val;
    ListNode next;

    ListNode(int val , ListNode next){
    this.val = val;
    this.next = next;
    }

    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}

public class SortLL {
    public ListNode sortList(ListNode head) { // brute force
        ArrayList<Integer> arr = new ArrayList<>();
        ListNode temp = head;
        while(temp!=null){
            arr.add(temp.val);
            temp = temp.next;
        }

        Collections.sort(arr);

        temp = head;
        for(int i = 0; i<arr.size(); i++){
            temp.val = arr.get(i);
            temp = temp.next;
        }
        return head;
    }

     // Function to print linked list
    static void printLinkedList(ListNode head) {
        // Pointer to traverse list
        ListNode temp = head;

        // Traverse and print values
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
          // Create linked list: 3 -> 2 -> 5 -> 4 -> 1
        ListNode head = new ListNode(3);
        head.next = new ListNode(2);
        head.next.next = new ListNode(5);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(1);

        // Print original list
        System.out.print("Original Linked List: ");
        printLinkedList(head);

        // Create Solution object
        SortLL obj = new SortLL();

        // Sort the linked list
        head = obj.sortList(head);

        // Print sorted list
        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
    }
}
