// Length of Loop in Linked List
// Problem Statement: Given the head of a linked list, determine the length of a loop present in the linked list. If there's no loop present, return 0.

import java.util.HashMap;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class LengthofLoop {
    public static int bruteForce(ListNode head) {
        // in this solution we will be using the hash map to solve problem with a timer;
        ListNode temp = head;
        int timmer = 0;
        HashMap<ListNode, Integer> map = new HashMap<>();
        while (temp != null) {
            if (map.containsKey(temp)) {
                int looplength = timmer - map.get(temp);
                return looplength;
            }
            map.put(temp, timmer);
            temp = temp.next;
            timmer++;
        }
        return 0;
    }

    // Now lets code the optimal solution
    public static int countLength(ListNode slow) {
        ListNode temp = slow;
        int count = 1;
        while (temp.next != slow) {
            temp = temp.next;
            count++;
        }
        return count;
    }

    public static int Optimal(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && slow != null) {
            fast = fast.next.next;
            slow = slow.next;
            if (slow == fast) {
                return countLength(slow);
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        // Creating a sample linked list with a loop
        ListNode head = new ListNode(1);
        ListNode second = new ListNode(2);
        ListNode third = new ListNode(3);
        ListNode fourth = new ListNode(4);
        ListNode fifth = new ListNode(5);

        // Linking the nodes
        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;

        // Creating a loop from fifth to second
        fifth.next = second;
        int loopLength = Optimal(head);

        // Printing the result
        if (loopLength > 0) {
            System.out.println("Length of the loop: " + loopLength);
        } else {
            System.out.println("No loop found in the linked list.");
        }
    }
}
