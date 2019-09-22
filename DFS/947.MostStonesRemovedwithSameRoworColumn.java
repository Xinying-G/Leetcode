// 947. Most Stones Removed with Same Row or Column
// On a 2D plane, we place stones at some integer coordinate points.  Each coordinate point may have at most one stone.

// Now, a move consists of removing a stone that shares a column or row with another stone on the grid.

// What is the largest possible number of moves we can make?

 

// Example 1:

// Input: stones = [[0,0],[0,1],[1,0],[1,2],[2,1],[2,2]]
// Output: 5
// Example 2:

// Input: stones = [[0,0],[0,2],[1,1],[2,0],[2,2]]
// Output: 3
// Example 3:

// Input: stones = [[0,0]]
// Output: 0

// union find
// 储存所有的element为自己的头，如果有必要union就union
// union: if(头(a) != 头(b)) join, island--;, parent of a = b;
// find(if(s != s) s = map.get(s)) 找hashmap里存的头


class Solution {
    Map<String,String> parent;
    int counter;
    public int removeStones(int[][] stones) { 
        parent = new HashMap<>();
        counter = 0;
        for(int i = 0; i < stones.length; i++){
            String s = stones[i][0] + " " + stones[i][1];
            parent.put(s,s);
            counter++;
        }
        for(int[] s1: stones){
            for(int[] s2: stones){
                if(s1[0] == s2[0] || s1[1] == s2[1]){
                    union(s1,s2);
                }
            }
        }
        return stones.length - counter;
    }
    
    public void union(int[] s1, int[] s2){
        String p1 = find(s1);
        String p2 = find(s2);
        if(!p1.equals(p2)){
            parent.put(p2,p1);
            counter--;
        }
    }
    
    public String find(int[] s){
        String cur = s[0] + " " + s[1];
        while(parent.get(cur) != cur){
            cur = parent.get(cur);
        }
        return cur;
    }
}