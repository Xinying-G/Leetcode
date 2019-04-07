// Given a sorted linked list, delete all duplicates such that each element appear only once.

// Example
// Example 1:
//     Input:  null
//     Output: null


// Example 2:
//     Input:  1->1->2->null
//     Output: 1->2->null
    
// Example 3:
//     Input:  1->1->2->->3->3->null
//     Output: 1->2->3->null
    
// Remove duplicate node


public class Solution {
    /**
     * @param head: head is the head of the linked list
     * @return: head of linked list
     */
    public ListNode deleteDuplicates(ListNode head) {
        // write your code here
    if(head == null) return head;
    ListNode pre = head;
    ListNode cur = head.next;
    while(cur != null )
    {
        if(cur.val == pre.val){
            pre.next = cur.next;
            cur = cur.next;
        }
        else{
            pre = pre.next;
            cur = cur.next;
        }
    }
    return head;
    }
}