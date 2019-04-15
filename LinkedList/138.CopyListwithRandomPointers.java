// 138. Copy List with Random Pointer
// A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.

// Return a deep copy of the list.
/*
// Definition for a Node.
class Node {
    public int val;
    public Node next;
    public Node random;

    public Node() {}

    public Node(int _val,Node _next,Node _random) {
        val = _val;
        next = _next;
        random = _random;
    }
};
*/
class Solution {
    public Node copyRandomList(Node head) {
        if(head == null) return null;

        Node t1 = head;
        while(t1 != null)
        {
            Node t2 = new Node();
            t2.val = t1.val;
            t2.next = t1.next;
            t1.next = t2;
            t1 = t2.next;
        }
        
        t1 = head;
        Node t2 = t1.next;
        while(true)
        {
            if(t1.random == null) t2.random = null;
            else
            {
                t2.random = t1.random.next;
            }
            t1 = t2.next;
            if(t1 == null)break;
            t2 = t1.next;
        }
        
        t1 = head;
        t2 = t1.next;
        if(t2.next == null)
        {
            t1.next = null;
            return t2;
        }
        Node ori = t1;
        Node copy = t2;
        Node t3 = t2.next;
        Node t4 = t3.next;
        while(true)
        {
            t1.next = t3;
            t2.next = t4;
            t1 = t3;
            t2 = t4;
            t3 = t2.next;
            if(t3 == null) {t1.next = null; t2.next = null; break;}
            t4 = t3.next;
        }
        return copy;
        
    }
}