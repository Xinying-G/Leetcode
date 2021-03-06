// 110. Balanced Binary Tree
// Given a binary tree, determine if it is height-balanced.

// For this problem, a height-balanced binary tree is defined as:

// a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

// Example 1:

// Given the following tree [3,9,20,null,null,15,7]:

//     3
//    / \
//   9  20
//     /  \
//    15   7

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
    public boolean isBalanced(TreeNode root) {
        if(dfs(root,0) != -5)
            return true;
        else return false;
    }
    
    public int dfs(TreeNode root, int depth)
    {
        if(root == null) return depth;
        int left_depth = dfs(root.left,depth+1);
        int right_depth = dfs(root.right,depth+1);
        if(Math.abs(left_depth - right_depth) > 1)
            return -5;
        return Math.max(left_depth, right_depth);
    }
}