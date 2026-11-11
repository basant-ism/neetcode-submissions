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
[0, n-1, 1, n-2, 2, n-3, ...]
0 1 2 
n-1 n-2 n-3

n=7
0, 1, 2, 3
6, 5, 4

(n)/2 + 1

n=6
0 1 2 3

5,4 

n=8
0 7 1 6 2 5 3 4

7 6 5

n/2 + 1


0 1 2 3 4 5 6 7

0 1 2 3 4 
5 6 7


0 1 2 3 4 
7 6 5


left=0
right=7, 6

0 --> 7 --> 1
*/
class Solution {
    int len(ListNode head) {
        int cnt =0;
        while(head!=null){
            cnt++;
            head=head.next;
        }
        return cnt;
    }
    ListNode midPrev(ListNode head) {
        int n = len(head);
        int mid = n/2 + 1;
        while(mid>1) {
            head = head.next;
            mid--;
        }
        return head;
    }
    ListNode reverse(ListNode head) {
        ListNode curr = head;
        ListNode prev = null;
        while(curr!=null) {
            ListNode temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode midPrevNode = midPrev(head);
        ListNode midNode = midPrevNode.next;
        ListNode left = head;
         
        midPrevNode.next = null;
        ListNode right = reverse(midNode);
        while(right!=null) {
            ListNode temp = left.next;
            left.next = right;
            right=right.next;
            left.next.next = temp;
            left=temp;
        }
    }
}
