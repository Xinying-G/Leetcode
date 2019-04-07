/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
// 105. Construct Binary Tree from Preorder and Inorder Traversal
// Given preorder and inorder traversal of a tree, construct the binary tree.

// Note:
// You may assume that duplicates do not exist in the tree.

// For example, given

// preorder = [3,9,20,15,7]
// inorder = [9,3,15,20,7]
class Solution {
    int index = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder == null || preorder.length == 0) return null; 
        int start = 0, end = preorder.length-1;
        TreeNode root = new TreeNode(preorder[index]);
        int pos = indexOf(start,end,inorder,preorder[index]);
        dfs(preorder,inorder,start,pos-1,root,true);
        System.out.printf(" first start %d ",pos+1);
        System.out.printf(" first end %d ",end);
        dfs(preorder,inorder,pos+1,end,root,false);
        return root;
    }
    
    public void dfs(int[] preorder, int[] inorder, int start, int end,TreeNode root,boolean left)
    {
        index++;
        if(index >= preorder.length) return;
        int pos = indexOf(start,end,inorder,preorder[index]);
        if(pos == -1) index--;
        if(start > pos) return;
        if(end < pos) return; 
        if(left){
            root.left = new TreeNode(preorder[index]);
            dfs(preorder,inorder,start,pos-1,root.left,true);
            dfs(preorder,inorder,pos+1,end,root.left,false);
        } 
        else{ 
            root.right = new TreeNode(preorder[index]);
            dfs(preorder,inorder,start,pos-1,root.right,true);
            dfs(preorder,inorder,pos+1,end,root.right,false);
        }
    }
    
    private int indexOf(int start,int end,int[] inorder, int value)
    {
        for(int i = start; i <= end; i++){
            if(inorder[i] == value) return i;
        }
        return -1;
    }
}