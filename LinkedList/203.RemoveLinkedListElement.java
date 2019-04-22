// 203. Remove Linked List Elements
// Remove all elements from a linked list of integers that have value val.

// Example:

// Input:  1->2->6->3->4->5->6, val = 6
// Output: 1->2->3->4->5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode removeElements(ListNode head, int val) {
        if(head == null) return null;
        ListNode pre;
        ListNode cur = head;
        while(cur != null && cur.val == val)
        {
            head = head.next;
            cur = head;
        }

        while(cur != null)
        {
            pre = cur;
            cur = cur.next;
            while(cur != null && cur.val == val)
            {
                pre.next = cur.next;
                cur = pre.next;
            }
        }
        
        return head;
    }
}