// LinkedList： Remove， Insert，Merge，Partition，
// reverse，findMiddle

// 86. Partition List
// Medium

// Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

// You should preserve the original relative order of the nodes in each of the two partitions.

// Example:

// Input: head = 1->4->3->2->5->2, x = 3
// Output: 1->2->2->4->3->5
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

// 直觉：太难了
// 要点，难点：1. 如何把list贴在后面
// 2.其实不用这么难，其实用两个dummy node，然后小于3的贴在第一个上，大于3的贴在第二个上，两个一合并就是了
// 归类：LinkedList
// 难点: LikedList
// 复杂度： O(n)
// 数据结构：for loop，LinkedList
class Solution {
    public ListNode partition(ListNode head, int x) {
        if(head == null) return head;
        if(head.next == null) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;
        ListNode cur = head;
        ListNode end = head;
        int counter = 0;
        while(end.next != null){
            counter++;
            end = end.next;
        }
        ListNode back = end;
        while(counter > 0)
        {
            counter--;
            if(cur.val >= x)
            {
                pre.next = cur.next;
                back.next = cur;
                back = back.next;
                cur.next = null;
                cur = pre.next;
            }
            else
            {
                pre = pre.next;
                cur = cur.next;
            }
        }
        return dummy.next;
    }
}

class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode dummy1 = new ListNode(0), dummy2 = new ListNode(0);  
        //dummy heads of the 1st and 2nd queues
        ListNode curr1 = dummy1, curr2 = dummy2;      //current tails of the two queues;
        while (head!=null){
            if (head.val<x) {
                curr1.next = head;
                curr1 = head;
            }else {
                curr2.next = head;
                curr2 = head;
            }
            head = head.next;
        }
        curr2.next = null;          
        //important! avoid cycle in linked list. otherwise u will get TLE.
        curr1.next = dummy2.next;
        return dummy1.next;
    }
}