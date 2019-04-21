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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(inorder == null || postorder == null || inorder.length != postorder.length)
            return null;
        HashMap<Integer, Integer> hm = new HashMap<>();
        for(int i = 0; i < inorder.length; i++)
        {
            hm.put(inorder[i],i);
        }
        return helper(inorder,0,inorder.length-1,postorder,0,postorder.length-1,hm);
    }
    
    public TreeNode helper(int[] inorder, int is, int ie, int[] postorder, int ps, int pe,HashMap<Integer,Integer> hm)
    {
        if(is > ie) return null;
        System.out.println(postorder[pe]);
        int ri = hm.get(postorder[pe]);
//         is - > ri left ri->ie right
        TreeNode root = new TreeNode(postorder[pe]);
        TreeNode left = helper(inorder,is,ri-1,postorder,ps,ps+ri-is-1,hm);
        TreeNode right = helper(inorder,ri+1,ie,postorder,ps+ri-is,pe-1,hm);
        root.left = left;
        root.right = right;
        return root;
    }
}