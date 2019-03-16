// 64. Minimum Path Sum
// Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

// Note: You can only move either down or right at any point in time.

// Example:

// Input:
// [
//   [1,3,1],
//   [1,5,1],
//   [4,2,1]
// ]
// Output: 7
// Explanation: Because the path 1→3→1→1→1 minimizes the sum.

// 直觉：dp
// 要点，难点：1. 每一个格子都等于自己+之前可以最小的位置（左边或者上边的格子的值）
// 2. 第一行的值也等于前一个+后一个
// 3第一列的值也等于前一个+后一个
// 归类：dp
// 难点: start的位置
// 复杂度： O(nm)
// 数据结构：DP


class Solution {
    public int minPathSum(int[][] grid) {
        
        int m = grid.length, n = grid[0].length;
        int[][] dp = new int[m][n];
        dp[0][0] = grid[0][0];
        for(int i = 1; i < m; i++)
        {
            dp[i][0] = grid[i][0]+dp[i-1][0];
        }
        for(int i = 1; i < n; i++)
        {
            dp[0][i] = grid[0][i] + dp[0][i-1];
        }
        
        for(int i = 1; i < m; i++)
        {
            for(int j = 1; j < n; j++)
            {
                dp[i][j] = grid[i][j] + Math.min(dp[i-1][j],dp[i][j-1]);
            }
        }
        
        return dp[m-1][n-1];
            
    }
}