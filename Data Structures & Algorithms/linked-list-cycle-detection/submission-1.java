/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public boolean hasCycle(ListNode head) {
        // HashSet<ListNode> set = new HashSet<>();
        // if(head == null) return false;
        // ListNode temp = head;
        // while(temp!=null) {
        //     if(set.contains(temp)) return true;
        //     set.add(temp);
        //     temp = temp.next;
        // }
        // return false;



        ListNode fast = head;
        ListNode slow = head;
        while(fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            if(slow==fast) return true;
        }
        return false;
    }
}
