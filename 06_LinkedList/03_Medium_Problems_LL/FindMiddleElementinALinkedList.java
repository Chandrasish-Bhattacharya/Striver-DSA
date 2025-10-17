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

public class FindMiddleElementinALinkedList {
    public static int bruteForce(Node head) { // my sol
        int arr[] = new int[20];
        int i = 0;
        Node temp = head;
        while (temp != null) {
            arr[i++] = temp.data;
            temp = temp.next;
        }
        int mid = (i % 2 == 0) ? i / 2 + 1 : i / 2;
        return arr[mid];
    }

    public static Node brute(Node head) {
        int mid = 0;
        Node temp = head;
        int n = 0;
        while (temp != null) {
            n++;
            temp = temp.next;
        }
        temp = head;
        mid = (n % 2 == 0) ? n / 2 + 1 : n / 2;
        while (temp != null) {
            mid--;
            if (mid == 0) {
                break;
            }
            temp = temp.next;
        }
        return temp;
    }

    public static Node Optimal(Node head) {
        Node rabbit = head;
        Node turtle = head;
        while (rabbit != null && rabbit.next != null && turtle != null) {
            turtle = turtle.next;
            if (rabbit.next.next != null) {
                rabbit = rabbit.next.next;
            }
            else break;
        }
        return turtle;
    }

    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.next = new Node(3);
        head.next.next.next = new Node(4);
        head.next.next.next.next = new Node(5);

        // Find the middle node
        int middleNode = bruteForce(head);

        // Display the value of the middle node
        System.out.println("The middle node value is: " + middleNode);
    }
}