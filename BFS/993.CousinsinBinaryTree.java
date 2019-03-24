// 993. Cousins in Binary Tree

// In a binary tree, the root node is at depth 0, and children of each depth k node are at depth k+1.
// Two nodes of a binary tree are cousins if they have the same depth, but have different parents.
// We are given the root of a binary tree with unique values, and the values x and y of two different nodes in the tree.
// Return true if and only if the nodes corresponding to the values x and y are cousins.

// 直觉：BFS
// 要点，难点：要判断同一层是不是一个parent，
// 解决方法：设置一个global变量记录parent，如果parent是相同的就不行，然后记录深度，如果深度相同且都不为-1，就可以 
// 归类：BFS
// 难点: global variable
// 复杂度： O（logn）
// 数据结构：BFS

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
    TreeNode parent1;
    TreeNode parent2;
    int depth1 = -1;
    int depth2 = -1;
    public boolean isCousins(TreeNode root, int x, int y) {

        if(root == null) return false;        
        bfs(root,x,y,0);
        if(parent1 != parent2 && depth1 == depth2 && depth1 != -1)
            return true;
        return false;
    }
    
    public void bfs(TreeNode root, int x, int y,int depth){
        if(root == null) return;
        if(root.left != null && root.left.val == x){
            parent1 = root;
            depth1 = depth+1;
        }
        if(root.left != null && root.left.val == y)
        {
            parent2 = root;
            depth2 = depth+1;
        }
        
        if(root.right != null && root.right.val == x){
            parent1 = root;
            depth1 = depth+1;
        }
        if(root.right != null && root.right.val == y){
            parent2 = root;
            depth2 = depth+1;
        }
        bfs(root.left,x,y,depth+1);
        bfs(root.right,x,y,depth+1);
    }
}