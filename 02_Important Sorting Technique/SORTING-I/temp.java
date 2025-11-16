// 3217. Delete Nodes From Linked List Present in Array

import java.util.HashSet;
import java.util.Set;

class Solution {
    public ListNode modifiedList(int[] nums, ListNode head) {
        ListNode temp = head;
        ListNode prev = null;
        for(int i : nums){
            while (temp!=null) {
                if(temp.data == i){
                    prev.next = temp.next;
                    prev = temp.next;
                    temp = temp.next.next;
                }
                else{
                prev = temp;
                temp = temp.next;
                }
            }
        }
        return head;
    }
}
public class temp{
public ListNode modifiedList(int[] nums, ListNode head) {
    Set<Integer> set = new HashSet<>();
    for (int i : nums) set.add(i);

    ListNode dummy = new ListNode(0, head);
    ListNode temp = head;
    ListNode prev = dummy;

    while (temp != null) {
        if (set.contains(temp.val)) {
            prev.next = temp.next;
        } else {
            prev = temp;
        }
        temp = temp.next;
    }

    return dummy.next;
}

}