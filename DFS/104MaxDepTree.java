// 104. Maximum Depth of Binary Tree

// Given a binary tree, find its maximum depth.

// The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

// Note: A leaf is a node with no children.

// Example:

// Given binary tree [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its depth = 3.

// 最简单的dfs

class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) return 0; 
        return dfs(root, 0);
    }
    
    public int dfs(TreeNode root, int level)
    {
        if(root == null) return level;
        
        return Math.max(dfs(root.left,level+1),dfs(root.right,level+1));
    }
}