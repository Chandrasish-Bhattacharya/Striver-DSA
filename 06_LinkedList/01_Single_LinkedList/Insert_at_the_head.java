import java.util.Arrays;
import java.util.List;

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
public class Insert_at_the_head {
    public static Node insertHead(Node Head , int data) {
        Node n = new Node(data);
        n.next = Head;
        Head = n;
        return Head;
    }
    public static void printLL(Node Head){
        Node temp = Head;
        while(temp!=null){
            System.out.println(temp.data);
            temp = temp.next;
        }
    }
    public static void main(String[] args) {
        List<Integer> arr = Arrays.asList(12, 8, 5, 7);
        int val = 100;

        // Creating a linked list with initial elements from the array
        Node head = new Node(arr.get(0));
        head.next = new Node(arr.get(1));
        head.next.next = new Node(arr.get(2));
        head.next.next.next = new Node(arr.get(3));

        // Inserting a new node at the head of the linked list
        head = insertHead(head, val);

        // Printing the linked list
        printLL(head);
    }
}
