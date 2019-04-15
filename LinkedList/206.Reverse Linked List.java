超级难LinkedList的题
// 206. Reverse Linked List
// Reverse a singly linked list.

// Example:

// Input: 1->2->3->4->5->NULL
// Output: 5->4->3->2->1->NULL
// Follow up:

// A linked list can be reversed either iteratively or recursively. Could you implement both?

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 直觉：三个指针轮流直到最后换好
// 要点，难点：1. 换不好
// 2.设置一个new head，把自己的head的next设置为new head，然后head = head。next，
// newhead则是新的head
// 归类：LinkedList
// 难点: 3个指针循环直到找到末尾
// 复杂度： O(n)
// 数据结构：Iteration

class Solution {
    public ListNode reverseList(ListNode head) {
        ListNode newhead = null;
        while(head != null)
        {
            ListNode next = head.next;
            head.next = newhead;
            newhead = head;
            head = next;
        }
        
        return newhead;
                
    }
}