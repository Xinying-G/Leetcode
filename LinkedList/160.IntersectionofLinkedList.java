// 160. Intersection of Two Linked Lists
// Write a program to find the node at which the intersection of two singly linked lists begins.

// For example, the following two linked lists:
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        ListNode t1 = headA, t2 = headB;
        while(t1 != null || t2 != null)
        {
            if(t1 == t2) return t1;  
            t1 = t1 == null? headB : t1.next;
            t2 = t2 == null? headA : t2.next;
        }
        return null;
    }
    
}