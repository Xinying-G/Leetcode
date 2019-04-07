/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

class Solution {
    public ListNode oddEvenList(ListNode head) {
        if(head == null || head.next == null)
            return head;
        ListNode end = head;
        while(end.next != null) end = end.next;
        ListNode end1 = end;
        ListNode t1 = head;
        ListNode t2 = head.next;
        if(t2.next == null) return head;
        ListNode t3 = head.next.next;  
        while(t1 != end1 && t2 != end1)
        {
            t1.next = t3;
            end.next = t2;
            t2.next = null;
            end = t2;
            t1 = t3;
            t2 = t1.next;
            t3 = t2.next;
        }
        if(t2 == end1)
        {
            t1.next = t2.next;
            end.next = t2;
            t2.next = null;
        }
        return head;
    }
}