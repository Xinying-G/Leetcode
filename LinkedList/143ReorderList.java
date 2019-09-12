// 143. Reorder List
// Medium

// 815

// 63

// Favorite

// Share
// Given a singly linked list L: L0→L1→…→Ln-1→Ln,
// reorder it to: L0→Ln→L1→Ln-1→L2→Ln-2→…

// You may not modify the values in the list's nodes, only nodes itself may be changed.

// Example 1:
// Given 1->2->3->4, reorder it to 1->4->2->3.

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void reorderList(ListNode head) {
        if(head == null || head.next == null) return;
        ListNode mid = findMid(head);
        ListNode reversed = reverse(mid.next);
        mid.next = null;
        // combine those LinkedList
        ListNode t1 = head;
        ListNode t2 = reversed;
        ListNode t3 = t1.next;
        ListNode t4 = t2.next;
        while(t1 != null && t2 != null)
        {
            t1.next = t2;
            // System.out.println(t1.val);
            // System.out.println(t1.next.val);
            t2.next = t3;
            // System.out.println(t3.val);
            // System.out.println(t3.next.val);
            t1 = t3;
            t2 = t4;
            if(t1 != null)t3 = t1.next;
            if(t2 != null)t4 = t2.next;
        }
        
    }
    
    // Find mid
    public ListNode findMid(ListNode head)
    {
        ListNode t1 = head;
        ListNode t2 = head;
        while(t1.next != null && t1.next.next != null)
        {
            t1 = t1.next.next;
            t2 = t2.next;
        }
        return t2;
    }
    
    //Reverse the last part of list
    public ListNode reverse(ListNode head)
    {
        ListNode t1 = head;
        ListNode t2 = t1.next;
        if(t2 == null) return t1;
        ListNode t3 = t2.next;
        while(t3 != null)
        {
            t2.next = t1;
            t1 = t2;
            t2 = t3;
            t3 = t3.next;
        }
        t2.next = t1;
        head.next = null;
        return t2;
    }
}