// 24. Swap Nodes in Pairs
// Medium
// Given a linked list, swap every two adjacent nodes and return its head.
// You may not modify the values in the list's nodes, only nodes itself may be changed.
// Example:

// Given 1->2->3->4, you should return the list as 2->1->4->3.
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 直觉：LinkedList
// 要点，难点：一个一个置换并且找出所有的可能性，设置了4个指针，找出正确的解
// 解决方法：设置了4个指针，如果在ite的过程中t1出现了null或者t2出现了null，都不再继续，否则的话就交换t1,t2,
// 2。这道题之中必须有头和尾巴两个指针指向两个不变的应该有的pre和next的位置，因此在这种情况下我们需要4个指针。
// 归类：linkedlist
// 难点: 4个指针的交换
// 复杂度： O（n）
// 数据结构：LinkedList
class Solution {
    public ListNode swapPairs(ListNode head) {
        if(head == null) return head;
        if(head.next == null) return head;
        ListNode t1 = head;
        ListNode t2 = head.next;
        ListNode pre = null;
        ListNode nex = t2.next;
        while(t2 != null)
        {
            if(pre == null) 
            {
                head = t2;
                t2.next = t1;
                t1.next = nex;
                pre = t1;
                t1 = t1.next;
                if(t1 == null) return head; else t2 = t1.next;
                if(t2 == null) return head; else nex= t2.next;
            }
            else 
            {               
                pre.next = t2;
                t2.next = t1;
                t1.next = nex;
                pre = t1;
                t1 = t1.next;
                if(t1 == null) return head; else t2 = t1.next;
                if(t2 == null) return head; else nex= t2.next;
            }
        }
        return head;
        
    }
}

// 直觉：优秀解法
// 要点，难点：将问题用recursion的方法做出来，将每一个要交换的node作为一个节点，对于每一个节点来说如果节点1是空或者
// 节点2是空，就return，head，否则就交换，让head的next = 下一个节点的head， head.next的节点的next=head，然后return这个原来是head.next
// 的节点作为这个小交换的头，并且让它粘在上一个交换过的尾巴上
// 解决方法：recursion的linkedlist
// 归类：linkedlist
// 难点: recursion linkedlist
// 复杂度： O（n）
// 数据结构：LinkedList
class Solution{
    public ListNode swapPairs(ListNode head){
        if(head == null || head.next == null) return head;
        ListNode n = head.next;
        head.next = swapPairs(head.next.next);
        n.next = head;
        return n;
    }

}