// 63. Unique Paths II
// A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).

// The robot can only move either down or right at any point in time. The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).

// Now consider if some obstacles are added to the grids. How many unique paths would there be?
// Dp 问题 同62 不再赘述
class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] dp = new int[obstacleGrid.length][obstacleGrid[0].length];
        if(obstacleGrid[0][0] == 1) return 0;
        dp[0][0] = 1;
        for(int i = 1; i < obstacleGrid.length; i++)
        {
            if(obstacleGrid[i][0] == 1) dp[i][0] = 0;
            else dp[i][0] = dp[i-1][0];
        }
        for(int i = 1; i < obstacleGrid[0].length; i++)
        {
            if(obstacleGrid[0][i] == 1) dp[0][i] = 0;
            else dp[0][i] = dp[0][i-1];
        }
        for(int i = 1; i < obstacleGrid.length; i++)
        {
            for(int j = 1; j < obstacleGrid[0].length; j++)
            {
                if(obstacleGrid[i][j] == 1) dp[i][j] = 0;
                else dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        
        return dp[obstacleGrid.length-1][obstacleGrid[0].length-1];
    }
}