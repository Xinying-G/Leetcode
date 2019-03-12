// 83. Remove Duplicates from Sorted List
// Given a sorted linked list, delete all duplicates such that each element appear only once.

// Example 1:

// Input: 1->1->2
// Output: 1->2
// Example 2:

// Input: 1->1->2->3->3
// Output: 1->2->3

// 直觉：2 pointer 
// 要点，难点：1. 设置两个pointer，如果一样就一直去重复，直到去完
// 归类：double pointer
// 难点: linkedlist
// 复杂度： O（n）
// 数据结构：2 pointer
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head == null) return head;
        ListNode t1 = head;
        ListNode t2 = head.next;
        while(t2 != null)
        {
            while(t2 != null && t1.val == t2.val )
            {
                t1.next = t2.next;
                t2 = t1.next;
            }
            if(t2 == null) break;
            t1 = t1.next;
            t2 = t2.next;
        }
        return head;
    }
}