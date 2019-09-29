// 222. Count Complete Tree Nodes
// Given a complete binary tree, count the number of nodes.

// Note:

// Definition of a complete binary tree from Wikipedia:
// In a complete binary tree every level, except possibly the last, is completely filled, and all nodes in the last level are as far left as possible. It can have between 1 and 2h nodes inclusive at the last level h.

// Example:

// Input: 
//     1
//    / \
//   2   3
//  / \  /
// 4  5 6

// Output: 6

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//直觉：不会 O（n）
// 解题方法：检测height of整个tree，如果height of right == h-1,说明缺的node在right tree，否则在left tree，
// 如果在right tree 就加上左边的node的全部，然后再加上计算右边的，否则就计算右边的（2（h-1））个node，然后再计算左边的
// 重点难点：如何利用complete tree特性做到O（nlogn），就是看左边右边是不是complete tree，如果是的话就加上O(2^n)，否则就不
// 数据结构：Tree
class Solution {
    
    public int height(TreeNode root){
        return root == null? -1 : 1 + height(root.left);
    }
    public int countNodes(TreeNode root) {
        int h = height(root);
        return h < 0? 0: height(root.right) == h-1? 
            (1 << h) + countNodes(root.right): (1 << h-1) + countNodes(root.left);
        
    }
}