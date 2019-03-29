// 142. Linked List Cycle II
// Given a linked list, return the node where the cycle begins. If there is no cycle, return null.

// To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

// Note: Do not modify the linked list.

 

// Example 1:

// Input: head = [3,2,0,-4], pos = 1
// Output: tail connects to node index 1
// Explanation: There is a cycle in the linked list, where tail connects to the second node.

// 直觉：一个pointer走2步，一个pointer走1步，如果能相遇，则证明有cycle
// 要点，难点：1. 一个pointer走2步，一个pointer走1步，如果能相遇，则证明有cycle
// 2. 找到有cycle之后head向前走，有环的位置向后走，相遇的位置就是环的入口
// 归类：linkedlist
// 难点: head从头开始走，走到的地方就是环的入口
// 复杂度： O(n)
// 数据结构： Floyd's Tortoise and Hare
/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */


public class Solution {
    public ListNode detectCycle(ListNode head) {
        boolean cycle = false;
        ListNode t1 = head;
        ListNode t2 = head;
        if(head == null) return null;
        if(t1.next != null && t1.next.next != null && t1.next.next == t2) return t1;
        while(t2.next != null && t2.next.next != null)
        {
                t1 = t1.next;
                t2 = t2.next.next;          
                if(t1 == t2) {cycle = true; break;}
        }
        if(cycle == false)
            return null;
        else
        {
            while(t1 != head)
            {
                t1= t1.next;
                head = head.next;
            }
            return head;
        }
    }
}