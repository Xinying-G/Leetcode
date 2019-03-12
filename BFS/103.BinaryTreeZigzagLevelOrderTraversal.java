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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {

        LinkedList<TreeNode> stack = new LinkedList<TreeNode>();
        List<List<Integer>> res = new ArrayList();
        if(root == null) return res;
        stack.push(root);
        boolean reverse = false;
        while(!stack.isEmpty())
        {
            LinkedList<TreeNode> reached = new LinkedList();
            LinkedList<Integer> layer = new LinkedList<Integer>();
            reverse = !reverse;
            while(!stack.isEmpty())
            {
                TreeNode node;
                node = stack.poll();
                if(reverse) layer.addLast(node.val);
                else layer.addFirst(node.val);
                if(node.left != null) reached.add(node.left);
                if(node.right != null) reached.add(node.right);
            }
            res.add(layer);
            stack = reached;
        }
        return res;
    }
}