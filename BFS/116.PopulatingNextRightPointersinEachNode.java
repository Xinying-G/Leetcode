// 116. Populating Next Right Pointers in Each Node
// You are given a perfect binary tree where all leaves are on the same level, and every parent has two children. The binary tree has the following definition:

// struct Node {
//   int val;
//   Node *left;
//   Node *right;
//   Node *next;
// }
// Populate each next pointer to point to its next right node. If there is no next right node, the next pointer should be set to NULL.

// Initially, all next pointers are set to NULL.

/*
// Definition for a Node.
class Node {
    public int val;
    public Node left;
    public Node right;
    public Node next;

    public Node() {}

    public Node(int _val,Node _left,Node _right,Node _next) {
        val = _val;
        left = _left;
        right = _right;
        next = _next;
    }
};
*/
class Solution {
    public Node connect(Node root) {
        if(root == null) return null;
        Queue<Node> queue= new LinkedList<>();
        queue.add(root);
        while(!queue.isEmpty())
        {
            Queue<Node> queue2 = new LinkedList<>();
            Node pre = null;
            while(!queue.isEmpty())
            {
                Node pop = queue.poll();
                if(pre != null) pre.next = pop;
                pre = pop;
                if(pop.left != null)queue2.add(pop.left);
                if(pop.right != null)queue2.add(pop.right);
            }
            queue = queue2;      
        }       
        return root;
    }
}