// Example:

// Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
// Output: 7 -> 0 -> 8
// Explanation: 342 + 465 = 807.


/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int next = 0, digit = 0;
        ListNode l3 = new ListNode(0); 
        ListNode head = l3;
        while(l1 != null || l2 != null || next != 0)
        {
            digit += next;
            next = 0;
            if(l1 != null) {digit += l1.val; l1 = l1.next;} 
            if(l2 != null) {digit += l2.val; l2 = l2.next;}

            if(digit >= 10)
            {
                next = 1;
                digit = digit - 10;
            }
                        System.out.println(digit);
            l3.next = new ListNode(digit);
            l3 = l3.next;
            digit = 0;
        }
        return head.next;
    }
}