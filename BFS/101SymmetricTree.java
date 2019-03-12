// 101. Symmetric Tree
// Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

// For example, this binary tree [1,2,2,3,4,4,3] is symmetric:
//     1
//    / \
//   2   2
//  / \ / \
// 3  4 4  3
// But the following [1,2,2,null,3,null,3] is not:
//     1
//    / \
//   2   2
//    \   \
//    3    3
// Note:
// Bonus points if you could solve it both recursively and iteratively.

// 要点，难点：1.用recursion的方法解决bfs，分别解决tree两边的比较
// 2.想不出来！！！！
// 归类：BFS
// 难点: recursion 的方法解决BFS 
// 复杂度： O(n)
// 数据结构：BFS

class Solution {
    public boolean isSymmetric(TreeNode root) {
        return root == null || isSymmetricHelper(root.left, root.right);
    }
    
    public boolean isSymmetricHelper(TreeNode left, TreeNode right)
    {
        if(left == null || right == null)
            return left == right;
        if(left.val != right.val) return false;
        return isSymmetricHelper(left.left, right.right) &&
            isSymmetricHelper(left.right, right.left);
    }
}