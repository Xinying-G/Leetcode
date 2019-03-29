// 102. Binary Tree Level Order Traversal
// Given a binary tree, return the level order traversal of its nodes' values. (ie, from left to right, level by level).

// For example:
// Given binary tree [3,9,20,null,null,15,7],
//     3
//    / \
//   9  20
//     /  \
//    15   7
// return its level order traversal as:
// [
//   [3],
//   [9,20],
//   [15,7]
// ]

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 要点，难点：1.用BFS QUEUE
// 2. Queue<TreeNode> q = new Queue<TreeNode>();
// Queue.poll(): get the first element from queue
// 2.不能用stack因为注重顺序
// 归类：BFS
// 难点: BFS
// 复杂度： O(n)
// 数据结构：BFS
class Solution {
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        queue.add(root);        

        while(!queue.isEmpty())
        {
            Queue<TreeNode> reached = new LinkedList<TreeNode>();
            List<Integer> level = new ArrayList<Integer>();
            while(!queue.isEmpty())
            {
                TreeNode node = queue.poll();
                if(node.left != null) reached.add(node.left);
                if(node.right != null) reached.add(node.right);
                level.add(node.val);
            }
            res.add(level);
            queue = reached;
        }
        
        return res;
    }
}