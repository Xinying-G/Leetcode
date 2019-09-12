// 109. Convert Sorted List to Binary Search Tree
// Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

// Example:

// Given the sorted linked list: [-10,-3,0,5,9],

// One possible answer is: [0,-3,9,-10,null,5], which represents the following height balanced BST:

//       0
//      / \
//    -3   9
//    /   /
//  -10  5

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public TreeNode sortedListToBST(ListNode head) {
        if(head == null) return null;
        if(head.next == null) return new TreeNode(head.val);
        ListNode t1 = head;
        ArrayList<Integer> nums = new ArrayList<>();
        while(t1 != null)
        {
            nums.add(t1.val);
            t1 = t1.next;
        }
        int start = 0, end = nums.size()-1;
        return buildTree(nums,start,end);
    }
    
    public TreeNode buildTree(List<Integer> nums, int start, int end)
    {
        if(start > end) return null;
        int mid = (start+end)/2;
        TreeNode root = new TreeNode(nums.get(mid));
        root.left = buildTree(nums,start,mid-1);
        root.right = buildTree(nums,mid+1,end);
        return root;
    }
    
}