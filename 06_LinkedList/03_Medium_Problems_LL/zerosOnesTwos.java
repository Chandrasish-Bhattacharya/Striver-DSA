// Sort a Linked List of 0's 1's and 2's by changing links
// Problem Statement: Given a linked list containing only 0's, 1's, and 2's, sort the linked list by rearranging the links (not by changing the data values).
// Examples
// Input: 1 -> 2 -> 0 -> 1 -> 0 -> 2 -> NULL
// Output: 0 -> 0 -> 1 -> 1 -> 2 -> 2 -> NULL
// Input: 2 -> 1 -> 2 -> 0 -> 0 -> 1 -> NULL
// Output: 0 -> 0 -> 1 -> 1 -> 2 -> 2 -> NULL
class Node{
    int val;
    Node next;

    Node(int val){
        this.val = val;
        this.next = null;
    }
    Node(int val , Node next){
        this.val = val;
        this.next = next;
    }
}
public class zerosOnesTwos{

    public static Node sol(Node head){
        Node zeroNode = new Node(-1);
        Node oneNode = new Node(-1);
        Node secNode = new Node(-1);
        
        Node tailZero = zeroNode;
        Node tailOne = oneNode;
        Node tailSec = secNode;

        Node curr = head;

        while(curr != null){
            if(curr.val == 0){
                tailZero.next = curr;
                tailZero = tailZero.next;
            }
            else if(curr.val == 1){
                tailOne.next = curr;
                tailOne = tailOne.next;
            }
            else{
                tailSec.next = curr;
                tailSec = tailSec.next;
            }
            curr = curr.next;
        }

        tailZero.next = (oneNode.next != null) ? oneNode.next : secNode.next;
        tailOne.next = secNode.next;
        tailSec.next = null;
        head = zeroNode.next;
        return head;
    }
    static void printLinkedList(Node head) {
        // Pointer to traverse list
        Node temp = head;

        // Traverse and print values
        while (temp != null) {
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(1);
        head.next.next.next = new Node(0);
        head.next.next.next.next = new Node(0);

        head = sol(head);
        System.out.print("Sorted Linked List: ");
        printLinkedList(head);
    }
}