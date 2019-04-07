// 92. Reverse Linked List II

// Reverse a linked list from position m to n. Do it in one-pass.

// Note: 1 ≤ m ≤ n ≤ length of list.

// Example:

// Input: 1->2->3->4->5->NULL, m = 2, n = 4
// Output: 1->4->3->2->5->NULL


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 直觉：太难了，其实linked list要分情况讨论并且找清楚然后熟悉reverse LinkedList， Merge LinkedList，partition LinkedList， remove，insert
// 其实LinkedList并不难
// 要点，难点：1. reverse LinkedList
// 2. 考虑reverse第一位是head吗，需要加一个dummy node 然后从dummynode开始做
// 3. 是不是reverse到最后一位，如果是back就是空，连接在空上就好
// 归类：LinkedList
// 难点: LikedList
// 复杂度： O(n)
// 数据结构：for loop，LinkedList
class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if(n - m <= 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        for(int i = 0; i < m-1; i++)
        {
            pre = pre.next;
        }
        
        ListNode start = pre.next;
        ListNode end = dummy;
        for(int i = 0; i < n; i++)
        {
            end = end.next;
        }
        ListNode back = end.next;
        if(m-n == 1) {
            pre.next = end;
            end.next = start;
            start.next = back;
        }
        
        ListNode t1 = start;
        ListNode t2 = start.next;
        ListNode t3 = start.next.next;
        while(t1 != end)
        {
            t2.next = t1;
            t1 = t2;
            t2 = t3;
            if(t3 != null)t3 = t3.next;
        }
        pre.next = t1;
        start.next = back;
        return dummy.next;
    }
    
}