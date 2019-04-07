/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

// 257. Binary Tree Paths
// Given a binary tree, return all root-to-leaf paths.

// Note: A leaf is a node with no children.

// Example:

// Input:

//    1
//  /   \
// 2     3
//  \
//   5

// Output: ["1->2->5", "1->3"]
// Explanation: All root-to-leaf paths are: 1->2->5, 1->3

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> res = new ArrayList<>();
        if(root == null) return res;
        dfs(root,res,"");
        return res;
    }
    
    public void dfs(TreeNode root,List<String> res,String path)
    {
        if(root.left == null && root.right == null)
        {
            path += Integer.toString(root.val);
            res.add(path);
            return;
        }
        if(root.left != null)
        { 
            String newPath = new String(path);
            newPath += Integer.toString(root.val) + "->";
            dfs(root.left,res,newPath);
        }
        if(root.right != null)
        { 
            String newPath = new String(path);
            newPath += Integer.toString(root.val) + "->";
            dfs(root.right,res,newPath);  
        }
             
    }
}