// 662. Maximum Width of Binary Tree
// Medium
// Given a binary tree, write a function to get the maximum width of the given tree. The width of a tree is the maximum width among all levels. The binary tree has the same structure as a full binary tree, but some nodes are null.

// The width of one level is defined as the length between the end-nodes (the leftmost and right most non-null nodes in the level, where the null nodes between the end-nodes are also counted into the length calculation.

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
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

// Used BFS
// 
class Solution {
    public int widthOfBinaryTree(TreeNode root) {
        LinkedList<TreeNode> q = new LinkedList<>();
        q.add(root);
        int width = 0;
        while(!q.isEmpty()){
            while(!q.isEmpty() && q.peek() == null){
               q.poll();
            }
            while(!q.isEmpty() && q.peekLast() == null){
               q.pollLast();
            }            
            if(q.isEmpty()) return width;
            width = Math.max(width,q.size());
            LinkedList<TreeNode> temp = new LinkedList<>();
            while(!q.isEmpty())
            {
                TreeNode node = q.poll();
                if(node != null){                   
                    temp.add(node.left);
                    temp.add(node.right);
                }
                else
                {
                    temp.add(null);
                    temp.add(null);
                }
            }
            q = temp;
        }
        return width;
    }
}