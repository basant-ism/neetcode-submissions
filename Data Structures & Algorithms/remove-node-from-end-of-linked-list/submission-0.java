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
        while(n>1) {//2 ,1
            curr = curr.next;
            n--;
        }
        if(curr == head) {
            return curr.next;
        }
        if(curr.next!=null)
            curr.next = curr.next.next;
        else
            curr.next = null;
        return head;
    }
}
