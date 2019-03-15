// Given a linked list, determine if it has a cycle in it.

// To represent a cycle in the given linked list, we use an integer pos which represents the position (0-indexed) in the linked list where tail connects to. If pos is -1, then there is no cycle in the linked list.

 

// Example 1:
// 1->2->3->4->2

// Input: head = [3,2,0,-4], pos = 1
// Output: true
// Explanation: There is a cycle in the linked list, where tail connects to the second node.


// 直觉：追及问题的办法
// 要点，难点：double pointer
// 归类：追及问题
// 难点: 指针停止的位置就是出现cycle的位置
// 复杂度： O(n)
// 数据结构：Greedy

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
    public boolean hasCycle(ListNode head) {
        if(head == null) return false;
        ListNode walker = head;
        ListNode runner = head;
        while(runner.next != null && runner.next.next != null)
        {
            runner = runner.next.next;
            walker = walker.next;
            if(runner == walker) return true;
        }
        return false;
    }
}