// Starting point of loop in a Linked List
// Problem Statement: Given the head of a linked list that may contain a cycle, return the starting point of that cycle. If there is no cycle in the linked list return null.

import java.util.HashMap;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

class Solution {
    public Node detectCycle(Node head) {
        Node temp = head;
        HashMap<Node, Integer> hmap = new HashMap<>();
        while (temp != null) {
            hmap.put(temp, hmap.getOrDefault(temp, 0) + 1);
            if (hmap.get(temp) >= 2)
                return temp;
            temp = temp.next;
        }
        return null;
    }

    public Node detectStart_Better(Node head) {
        Node slow = head, fast = head;
        while (slow != null && slow.next != null && fast.next != null && fast != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                slow = head;
                while (slow != fast) {
                    slow = slow.next;
                    fast = fast.next;
                }
                return slow;
            }
        }
        return null;
    }
}

public class StartLoop {
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(15);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(13);
        head.next.next.next.next.next = new Node(6);
        head.next.next.next.next.next.next = new Node(7);
        head.next.next.next.next.next.next.next = new Node(8);
        head.next.next.next.next.next.next.next.next = new Node(9);

        // Create cycle
        head.next.next.next.next.next.next.next.next = head.next.next;

        Solution obj = new Solution();
        Node startNode = obj.detectStart_Better(head);

        if (startNode != null)
            System.out.println("Cycle starts at node with value: " + startNode.data);
        else
            System.out.println("No cycle found.");
    }
}