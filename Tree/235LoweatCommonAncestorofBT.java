// 235. Lowest Common Ancestor of a Binary Search Tree
// Given a binary search tree (BST), find the lowest common ancestor (LCA) of two given nodes in the BST.

// According to the definition of LCA on Wikipedia: “The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as descendants (where we allow a node to be a descendant of itself).”

// Given binary search tree:  root = [6,2,8,0,4,7,9,null,null,3,5]


class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        return (root.val - p.val) * (root.val - q.val) < 1? root: (root.val > p.val)?                            lowestCommonAncestor(root.left,p,q):lowestCommonAncestor(root.right,p,q);
    }
}