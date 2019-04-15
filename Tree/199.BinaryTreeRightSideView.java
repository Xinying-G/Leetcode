// 199. Binary Tree Right Side View
// Given a binary tree, imagine yourself standing on the right side of it, return the values of the nodes you can see ordered from top to bottom.

// Example:

// Input: [1,2,3,null,5,null,4]
// Output: [1, 3, 4]
// Explanation:

//    1            <---
//  /   \
// 2     3         <---
//  \     \
//   5     4       <---
/*
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> res = new ArrayList<>();
        traverse(root,res,0);
        return res;
        
    }
    
    public void traverse(TreeNode cur,List<Integer> res,int depth)
    {
        if(cur == null) return;
        if(depth == res.size())
        {
            res.add(cur.val);
        }
        traverse(cur.right,res,depth+1);
        traverse(cur.left,res,depth+1);
    }
}