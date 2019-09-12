// 113. Path Sum II

// Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

// Note: A leaf is a node with no children.

// Example:

// Given the below binary tree and sum = 22,

//       5
//      / \
//     4   8
//    /   / \
//   11  13  4
//  /  \    / \
// 7    2  5   1

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
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> res = new ArrayList<>();
        helper(0,sum,root,res,new ArrayList<>());
        return res;
    }
    
    public void helper(int value, int sum, TreeNode root, List<List<Integer>> res, List<Integer> level)
    {
        if(root == null) return;
        value += root.val;
        List<Integer> path = new ArrayList<>(level);
        path.add(root.val);
        if(root.left == null && root.right == null)
        {
            if(value == sum)
                res.add(path);
            else return;
        }
        helper(value,sum,root.left,res,path);
        helper(value,sum,root.right,res,path);
    }
}