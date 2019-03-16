// 94. Binary Tree Inorder Traversal
// Given a binary tree, return the inorder traversal of its nodes' values.

// Example:

// Input: [1,null,2,3]
//    1
//     \
//      2
//     /
//    3

// Output: [1,3,2]

// 直觉：stack!= 0 元先数据结构学的算法
// 要点，难点：1. 用了if continue，不如用while
// 2. 左，中，右，对于如果是最左了可以搞出来，然后看看最左的右边有没有值，有的话把右边当成root
// 3.tree 就是左边的枝当作root，或者右边的枝当成root
// 归类：Stack
// 难点: Stack
// 复杂度： O(n)
// 数据结构：dp
public List<Integer> inorderTraversal(TreeNode root) {
    List<Integer> list = new ArrayList<Integer>();

    Stack<TreeNode> stack = new Stack<TreeNode>();
    TreeNode cur = root;

    while(cur!=null || !stack.empty()){
        while(cur!=null){
            stack.add(cur);
            cur = cur.left;
        }
        cur = stack.pop();
        list.add(cur.val);
        cur = cur.right;
    }

    return list;
}