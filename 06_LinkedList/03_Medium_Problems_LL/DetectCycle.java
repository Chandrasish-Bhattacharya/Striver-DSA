// Detect a Cycle in a Linked List
// Problem Statement: Given a Linked List, determine whether the linked list contains a cycle or not.

import java.util.HashMap;

class Node {
    // Data stored in the node
    int data;

    // Pointer to the next node in the list
    Node next;

    // Constructor with both data 
    // and next node as parameters
    Node(int data1, Node next1) {
        data = data1;
        next = next1;
    }

    // Constructor with only data as
    // a parameter, sets next to null
    Node(int data1) {
        data = data1;
        next = null;
    }
}

public class DetectCycle {
    // so in the brute force we will using a hash map that will check that does this node is visited or not 
    public boolean detectBrute(Node head){
        HashMap<Node, Integer> map = new HashMap<>();
        Node temp = head;
        while(temp != null){
            if(map.containsKey(temp))
            return true;
            else 
            map.put(temp, 1);

            temp = temp.next;
        }
        return false;
    }
    public boolean detectOptimal(Node head){ // In this approch we will be using the rabbit algo
        Node rabbit = head , hare = head;
        while(rabbit.next!= null & rabbit !=null & hare != null){
            rabbit= rabbit.next.next;
            hare = hare.next;
            if(rabbit == hare) return true;
        }
        return false;
    }  
    
     public static void main(String[] args) {
        // Create a sample linked list
        // with a loop for testing
        Node head = new Node(1);
        Node second = new Node(2);
        Node third = new Node(3);
        Node fourth = new Node(4);
        Node fifth = new Node(5);

        head.next = second;
        second.next = third;
        third.next = fourth;
        fourth.next = fifth;
        // Create a loop
        fifth.next = third;

        DetectCycle sol = new DetectCycle();

        // Check if there is a loop 
        // in the linked list
        if (sol.detectOptimal(head)) {
            System.out.println("Loop detected in the linked list.");
        } else {
            System.out.println("No loop detected in the linked list.");
        }
    }
}
