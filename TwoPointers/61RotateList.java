// 61. Rotate List
// Example 1:

// Input: 1->2->3->4->5->NULL, k = 2
// Output: 4->5->1->2->3->NULL
// Explanation:
// rotate 1 steps to the right: 5->1->2->3->4->NULL
// rotate 2 steps to the right: 4->5->1->2->3->NULL
// Example 2:

// Input: 0->1->2->NULL, k = 4
// Output: 2->0->1->NULL
// Explanation:
// rotate 1 steps to the right: 2->0->1->NULL
// rotate 2 steps to the right: 1->2->0->NULL
// rotate 3 steps to the right: 0->1->2->NULL
// rotate 4 steps to the right: 2->0->1->NULL

// 直觉：rotate list 
// 要点，难点：1. 设置两个pointer，转，直到转完
// 归类：double pointer
// 难点: linkedlist
// 复杂度： O（n^2）
// 数据结构：2 pointer

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if(head == null) return head;
        if(head.next == null) return head;
        for(int i = 0; i < k; i++)
        {   
            ListNode t1 = head;
            ListNode t2 = head.next;
            while(t2.next != null)
            {
                t1 = t1.next;
                t2 = t2.next;
            }
            t1.next = null;
            t2.next = head;
            head = t2;
        }
        return head;
    }
}