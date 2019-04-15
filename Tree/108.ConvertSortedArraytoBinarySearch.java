// 108. Convert Sorted Array to Binary Search Tree
// Given an array where elements are sorted in ascending order, convert it to a height balanced BST.

// For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.
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
    public TreeNode sortedArrayToBST(int[] nums) {
        if(nums.length == 0) return null;
        int mid = (int)((0 + nums.length-1)/2 + 0.5);
        TreeNode root = new TreeNode(nums[mid]);
        buildTree(nums,0,mid-1,root,true);
        buildTree(nums,mid+1,nums.length-1,root,false);
        return root;
    }
    
    public void buildTree(int[] nums, int start, int end, TreeNode root, boolean left)
    {
        if(start > end) return;
        int mid = (int)((start + end)/2 + 0.5);
        if(left == true)
        {
            root.left = new TreeNode(nums[mid]);
            buildTree(nums,start,mid-1,root.left,true);
            buildTree(nums,mid+1,end,root.left,false);
        }
        else
        {
            root.right = new TreeNode(nums[mid]);
            buildTree(nums,start,mid-1,root.right,true);
            buildTree(nums,mid+1,end,root.right,false);
        }
    }
}