// 994. Rotting Oranges
// In a given grid, each cell can have one of three values:

// the value 0 representing an empty cell;
// the value 1 representing a fresh orange;
// the value 2 representing a rotten orange.
// Every minute, any fresh orange that is adjacent (4-directionally) to a rotten orange becomes rotten.

// Return the minimum number of minutes that must elapse until no cell has a fresh orange.  If this is impossible, return -1 instead.

// Input: [[2,1,1],[1,1,0],[0,1,1]]
// Output: 4

// 直觉：DFS
// 要点，难点：1. 对于每一次rotten来说，不可以直接改变grid因为这样可能会影响下一步，我用了一个boolean matrix
// 2. 用了一个done与否来判断是否做完，如果还有boolean matrix的东西没有做完，就not done
// 归类：BFS
// 难点: 许多个for循环
// 复杂度： O（n^n）
// 数据结构：BFS
class Solution {
    public int orangesRotting(int[][] grid) {
        int iter = 0;
        boolean done = false;
        int row = grid.length;
        int col = grid[0].length;
        boolean[][] rotten = new boolean[row][col];
        while(!done)
        {
            done = true;
            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    if(grid[i][j] == 2)
                    {
                        if(i-1 >= 0 && grid[i-1][j] == 1){rotten[i-1][j] = true;}
                        if(i+1 < row && grid[i+1][j] == 1){rotten[i+1][j] = true;}
                        if(j-1 >= 0 && grid[i][j-1] == 1){rotten[i][j-1] = true;}
                        if(j+1 < col && grid[i][j+1] == 1){rotten[i][j+1] = true;}
                    }
                }
            }

            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    if(rotten[i][j] == true) {
                        grid[i][j] = 2;
                        done = false;
                    }
                }
            }
            iter++;

            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    if(grid[i][j] == 1 && done == true) return -1;
                    System.out.printf("%d", grid[i][j]);
                }
            }

            for(int i = 0; i < row; i++)
            {
                for(int j = 0; j < col; j++)
                {
                    rotten[i][j] = false;
                }
            }
        }
        return --iter;
    }
}