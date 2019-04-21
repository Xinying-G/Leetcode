// 445. Add Two Numbers II
// You are given two non-empty linked lists representing two non-negative integers. The most significant digit comes first and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

// You may assume the two numbers do not contain any leading zero, except the number 0 itself.

// Follow up:
// What if you cannot modify the input lists? In other words, reversing the lists is not allowed.

// Example:

// Input: (7 -> 2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 8 -> 0 -> 7

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
// 直觉：reverse + linkedList相加
// 要点，难点：1. LinkedList 3的reverse
// 归类：LinkedList
// 难点: 如何写两个程序
// 复杂度：O(n) 
// 数据结构：LinkedList
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode n1 = reverseLinkedList(l1);
        ListNode n2 = reverseLinkedList(l2);
        ListNode dummy = new ListNode(0);
        ListNode n3 = dummy;
        int carry = 0;
        while(n1 != null || n2 != null)
        {
            int value = carry;
            if(n1 != null){value += n1.val; n1 = n1.next;} 
            if(n2 != null){value += n2.val; n2 = n2.next;} 
            if(value >= 10)
            {
                value -= 10;
                carry = 1;
            }
            else 
                carry = 0;
            
            n3.next = new ListNode(value);
            n3 = n3.next;
        }
        if(carry != 0) n3.next = new ListNode(1);
        return reverseLinkedList(dummy.next);
    }
    
    public ListNode reverseLinkedList(ListNode l1)
    {
        if(l1 == null || l1.next == null) return l1;
        ListNode t1 = l1;
        ListNode t2 = l1.next;
        ListNode t3 = l1.next.next;
        l1.next = null;
        while(t3 != null)
        {
            t2.next = t1;
            t1 = t2; t2 = t3;
            t3  = t3.next;
        }
        t2.next = t1;
        return t2;
    }
}