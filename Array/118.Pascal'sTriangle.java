// 118. Pascal's Triangle
// Easy

// 661

// 75

// Favorite

// Share
// Given a non-negative integer numRows, generate the first numRows of Pascal's triangle.


// In Pascal's triangle, each number is the sum of the two numbers directly above it.

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<>();
        if(numRows == 0) return res;
        List<Integer> pre = new ArrayList<>();
        pre.add(1);
        res.add(pre);
        if(numRows == 1) return res;
        while(numRows > 1)
        {
            List<Integer> level = new ArrayList<>();
            level.add(1);
            for(int i = 0; i < pre.size()-1; i++)
            {
                level.add(pre.get(i)+pre.get(i+1));
            }
            level.add(1);
            res.add(level);
            pre = level;
            numRows--;
        }
        return res;
    }
}