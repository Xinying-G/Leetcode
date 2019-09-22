import java.util.*;
import java.io.*;
// Definition for a Node.
public class LowestCommonAncestryNaryTree{
	public static Node LCA(Node root, Node p, Node q){
		if(root == null) return null;
		if(root.val == q.val) return root;
		if(root.val == p.val) return root;
		Node left = null, right = null;
		for(int i = 0; i < root.children.size(); i++){
			Node n1, n2;
			if(left == null && (n1 = LCA(root.children.get(i),p,q)) != null)
				left = n1;
			if(left != null && right == null && (n2 = LCA(root.children.get(i),p,q)) != null && n2 != left)
				right = n2;
		}
		if(left != null && right == null) return left;
		if(left == null && right != null) return right;
		if(left != null && right != null) return root;
		else return null;
	}

	public static void main(String[] args){
		Node n1 = new Node(0);
		Node n2 = new Node(1);
		Node n3 = new Node(2);
		Node n4 = new Node(3);
		Node n5 = new Node(4);
		Node n6 = new Node(5);
		Node n7 = new Node(6);
		Node n8 = new Node(7);
		n1.children = new ArrayList<>();
		n2.children = new ArrayList<>();
		n3.children = new ArrayList<>();
		n4.children = new ArrayList<>();
		n5.children = new ArrayList<>();
		n6.children = new ArrayList<>();
		n7.children = new ArrayList<>();
		n8.children = new ArrayList<>();
		n1.children.add(n2);
		n1.children.add(n3);
		n1.children.add(n4);
		n2.children.add(n5);
		n3.children.add(n6);
		n3.children.add(n7);
		n6.children.add(n8);

		Node t1 = new Node(1);
		Node t2 = new Node(3);

		System.out.println(LCA(n1, t1, t2).val);
	}

}

class Node {
    public int val;
    public List<Node> children;
    public Node() {}
    public Node(int _val) {
        val = _val;
    }
}
