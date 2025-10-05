// Search an element in a Linked List
// Problem Statement: Given the head of a linked list and an integer value, find out whether the integer is present in the linked list or not. Return true if it is present, or else return false.
// Example 1:
// Input Format: 0->1->2, val = 2
// Result True
// Explanation: Since element 2 is present in the list, it will return true.
// Example 2:
// Input Format: 12->5->8->7, val = 6 
// Result False
// Explanation: The list does not contain element 6. Therefore, it returns false.
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
public class CheckElement {
    public static boolean CheckEle(Node head, int x){
        while(head!=null){
            if(head.data == x) return true;
            head = head.next;
        }
        return false;
    }
    public static void main(String[] args) {
        // Create a linked list: 1 -> 2 -> 3
        int[] arr = {1, 2, 3};
        Node head = new Node(arr[0]);
        head.next = new Node(arr[1]);
        head.next.next = new Node(arr[2]);

        int val = 0;  // Element to be checked for presence in the linked list

        // Call the checkifPresent function and print the result
        System.out.print(CheckEle(head, val));
    }
}
