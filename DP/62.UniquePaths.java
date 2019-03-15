// 62. Unique Paths

// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

// How many possible unique paths are there?


// Above is a 7 x 3 grid. How many possible unique paths are there?

// Note: m and n will be at most 100.

// Example 1:

// Input: m = 3, n = 2
// Output: 3
// Explanation:
// From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
// 1. Right -> Right -> Down
// 2. Right -> Down -> Right
// 3. Down -> Right -> Right
// Example 2:

// Input: m = 7, n = 3
// Output: 28

// 直觉：dp
// 要点，难点：dp网格，这一个格子的数字=上面格子+下面格子的
// 归类：dp
// 难点: 
// 复杂度： O(nm)
// 数据结构：dp

class Solution {
    public int uniquePaths(int m, int n) {
        int[][] ways = new int[m][n];
        for(int i = 0; i < m; i++)
        {
            ways[i][0] = 1;
        }
        for(int i = 0; i < n; i++)
        {
            ways[0][i] = 1;
        }
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                ways[i][j] = ways[i-1][j] + ways[i][j-1];
            }
        }
        
        return ways[m-1][n-1];
    }
}