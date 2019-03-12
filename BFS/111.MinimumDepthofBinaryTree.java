// 111. Minimum Depth of Binary Tree
// Given a binary tree, find its minimum depth.

// The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

// Note: A leaf is a node with no children.

// Example:

// Given binary tree [3,9,20,null,null,15,7],

//     3
//    / \
//   9  20
//     /  \
//    15   7

// 直觉：dfs
// 要点，难点：1. 如果只有一个树枝怎么办？ 只算另外一半
// 归类：dfs
// 难点: 如果只有一个树枝怎么办
// 复杂度： O（n）
// 数据结构：DFS

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
    public int minDepth(TreeNode root) {
        if(root == null) return 0; 
        return minDepthHelper(root,0);
    }
    public int minDepthHelper(TreeNode root,int depth)
    {
        if(root.left == null && root.right == null)
            return depth+1;
        if(root.left == null) return minDepthHelper(root.right,depth+1);
        if(root.right == null) return minDepthHelper(root.left,depth+1);
        return Math.min(minDepthHelper(root.left,depth+1),minDepthHelper(root.right,depth+1));                       
    }
}