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
/*
head:1-->2-->3--->4--->5-->null
temp temp.next
temp.next.next = temp;
null<---1<--2<--3<---4<----5:head

1 2-->3-->4-->5

*/
class Solution {
    public ListNode reverseList(ListNode head) {
        if(head==null) return null;
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null) {
            ListNode temp = curr.next; //2
            curr.next = prev; //null
            prev = curr; //1
            curr = temp;//2
        }
        return prev;
    }
}
