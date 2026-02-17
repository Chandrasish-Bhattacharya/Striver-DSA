// Add two numbers represented as Linked Lists
// Problem Statement: Add two numbers represented as Linked Lists.
// Example 1:
// Input: num1 = 243, num2 = 564
// Output:sum = 807; L = [7,0,8]
// Explanation: Since the digits are stored in reverse order, reverse the numbers first to get the or original number and then add them as → 342 + 465 = 807.

// Example 2:
// Input: l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
// Output: Result: [8,9,9,9,0,0,0,1]
// Explanation: Since the digits are stored in reverse order, reverse the numbers first to get the original number and then add them as → 9999999 + 9999 = 8999001. Refer to the image below.

class Node {

    int val;
    Node next;
    Node(){}

    Node(int val) {
        this.val = val;
        this.next = null;
    }

    Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}

public class AddTwoNumbers{
    Node AddTwoNumbers(Node l1 , Node l2){
        Node dummy = new Node();
        Node temp = dummy;
        int carry = 0;

        while(l1 != null || l2 != null || carry!= 0){
            int sum = 0;
            if(l1 != null){
                sum += l1.val;
                l1 = l1.next;
            }
            if(l2 != null){
                sum += l2.val;
                l2 = l2.next;
            }
            sum += carry;
            carry = sum / 10;
            Node node = new Node(sum % 10);
            temp.next = node;
            temp = temp.next; 
        }
        return dummy.next;
    }
     static void printList(Node head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) System.out.print(" -> ");
            head = head.next;
        }
        System.out.println();
    }
    static Node createList(int[] arr) {
        Node head = new Node(arr[0]);
        Node temp = head;
        for (int i = 1; i < arr.length; i++) {
            temp.next = new Node(arr[i]);
            temp = temp.next;
        }
        return head;
    }
    public static void main(String[] args) {
        int[] num1 = {2, 4, 3}; // represents 342
        int[] num2 = {5, 6, 4}; // represents 465
        Node l1 = createList(num1);
        Node l2 = createList(num2);

        AddTwoNumbers sol = new AddTwoNumbers();
        Node result = sol.AddTwoNumbers(l1, l2);
        printList(result); // Output: 7 -> 0 -> 8
    }
}
