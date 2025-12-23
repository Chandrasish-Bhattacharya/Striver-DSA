// Segregate even and odd nodes in LinkedList
// Problem Statement: Given the head of a singly linked list. Group all the nodes with odd indices followed by all the nodes with even indices and return the reordered list. Consider the 1st node to have index 1 and so on. The relative order of the elements inside the odd and even group must remain the same as the given input.
// TUF
// Examples
// Input: 1→2→3→4→5→6→Null
// Output: 2→4→6→1→3→5→Null
// Explanation : Odd Nodes in LinkedList are 1,3,5 and Even Nodes in LinkedList are 2,4,6
// In Modified LinkedList all even Nodes comes before all Odd Nodes. So Modified LinkedList looks like 2→4→6→1→3→5→Null. Order of even and odd Nodes is 
// maintained in modified LinkedList.
// Input: 1→3→5→Null
// Output: 1→3→5→Null
// Explanation: As there are no Even Nodes in LinkedList, The Modified LinkedList is same as Original LinkedList.

// Given the head of a singly linked list, group all the nodes with odd indices together followed by the nodes with even indices, and return the reordered list.

// The first node is considered odd, and the second node is even, and so on.

// Note that the relative order inside both the even and odd groups should remain as it was in the input.

// You must solve the problem in O(1) extra space complexity and O(n) time complexity.

// Input: head = [1,2,3,4,5]
// Output: [1,3,5,2,4]

import org.w3c.dom.Node;

class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
    ListNode(int val , ListNode next){
        this.val = val;
        this.next = next;
    }
}
class Solution{
    public ListNode OddEvenList(ListNode head){
        if(head == null || head.next != null) return head;
        ListNode odd = head , even = head.next;
        ListNode oddHead = head , evenHead = head.next;
        while(even == null && even.next != null){
            odd.next = odd.next.next;
            even.next = even.next.next;

            odd = odd.next;
            even = even.next;
        }
        odd.next = evenHead;
        even.next = null;
        return oddHead;
    }
}
public class EvenAndOddInLL {
    public static void main(String[] args) {
        Solution sol = new Solution();

        // Creating linked list: 17 -> 15 -> 8 -> 12 -> 10 -> 5 -> 4
        ListNode head = new ListNode(17);
        head.next = new ListNode(15);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(12);
        head.next.next.next.next = new ListNode(10);
        head.next.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next.next = new ListNode(4);

        // Call segregation function
        ListNode newHead = sol.OddEvenList(head);

        // Print result
        while (newHead != null) {
            System.out.print(newHead.val + " ");
            newHead = newHead.next;
        }
    }
}
