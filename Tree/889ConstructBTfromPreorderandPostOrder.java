// 889. Construct Binary Tree from Preorder and Postorder Traversal

// Return any binary tree that matches the given preorder and postorder traversals.

// Values in the traversals pre and post are distinct positive integers.

 

// Example 1:

// Input: pre = [1,2,4,5,3,6,7], post = [4,5,2,6,7,3,1]
// Output: [1,2,3,4,5,6,7]
 
 // pre：中左右
// post：左右中，
// pre的node如果等于post的node，说明最开始=结尾，说明结束，不然的话，就以中为开始添加左子树和右子树，
// post的第一个位置为most left，我们iterate preorder，如果不是most left就一直往left添加left
// 直到遇到most left，返回上一层，添加右子树，直到添加完成
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
    int preInd = 0, postInd = 0;
    public TreeNode constructFromPrePost(int[] pre, int[] post) {
        if(preInd == pre.length) return null;
        TreeNode root = new TreeNode(pre[preInd++]);
        if(root.val != post[postInd])
            root.left = constructFromPrePost(pre,post);
        if(root.val != post[postInd])
            root.right = constructFromPrePost(pre,post);
        postInd++;
        return root;
    }
}