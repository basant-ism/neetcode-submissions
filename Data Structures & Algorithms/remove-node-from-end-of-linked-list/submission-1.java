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
    int len(ListNode head) {
        int cnt =0;
        while(head!=null) {
            cnt++;
            head=head.next;
        }
        return cnt;
    }
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int len = len(head);
        n = len - n;//2
        ListNode curr = head;
        ListNode prev = null;
        while(n>0) {//2 ,1
            prev = curr;
            curr = curr.next;
            n--;
        }
        if(curr == head) {
            return curr.next;
        }

        prev.next = curr.next;
 
        return head;
    }
}
