
import java.util.HashSet;
import java.util.Set;

// Find intersection of Two Linked Lists
// Problem Statement: Given the heads of two singly linked-lists headA and headB, return the node at which the two lists intersect. If the two linked lists have no intersection at all, return null.
// Example 1:
// Input:
// List 1 = [1,3,1,2,4], List 2 = [3,2,4]
// Output:
// 2
// Explanation:
//  Here, both lists intersecting nodes start from node 2.

// Example 2:
// Input:

//  List1 = [1,2,7], List 2 = [2,8,1]
// Output:

//  Null
// Explanation:
//  Here, both lists do not intersect and thus no intersection node is present.

class Node {
    int num;
    Node next;
    Node(int val) {
        num = val;
        next = null;
    }
    Node(int val , Node next){
        num = val ;
        this.next = next;
    }
}

public class Intersection{
    public void insertNode(Node head, int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            return;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
    }
    // firstly lets code the brute force
    public Node bruteForce(Node head1 , Node head2){
        while(head1 != null){
            Node temp = head2;
            while(temp != null){
                if(head1 == temp){
                    return temp;
                }
                temp = temp.next;
            }
            head1 = head1.next;
        }
        return null;
    }

    public Node betterSol(Node head1 , Node head2){
        Set<Node> s = new HashSet();
        while(head1 != null){
            s.add(head1);
            head1 = head1.next;
        }
        while(head2 != null){
            if(s.contains(head2)){
                return head2;
            }
            head2 = head2.next;
        }
        return null;
    }
    public Node optimalSol1(Node head1 , Node head2){
        Node d1 = head1;
        Node d2 = head2;

        while(d1 != d2){
            d1 = d1 == null ? head2 : d1.next;
            d2 = d2 == null ? head1 : d2.next;
        }
        return d1;
    }
    public static void main(String[] args) {
    // Creation of both lists
        Intersection sol = new Intersection();
        Node head = new Node(1);
        sol.insertNode(head, 3);
        sol.insertNode(head, 1);
        sol.insertNode(head, 2);
        sol.insertNode(head, 4);
        Node head1 = head;
        head = head.next.next.next; // Intersection point
        Node headSec = new Node(3);
        Node head2 = headSec;
        headSec.next = head; // Creating intersection

        // Printing of the lists
        // System.out.print("List1: ");
        // sol.printList(head1);
        // System.out.print("List2: ");
        // sol.printList(head2);

        // Checking if intersection is present
        Node answerNode = sol.optimalSol1(head1, head2);
        if (answerNode == null) {
            System.out.println("No intersection");
        } else {
            System.out.println("The intersection point is " + answerNode.num);
        }
    }
}