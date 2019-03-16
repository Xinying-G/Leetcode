// 200. Number of Islands
// Given a 2d grid map of '1's (land) and '0's (water), count the number of islands. An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.

// Example 1:

// Input:
// 11110
// 11010
// 11000
// 00000

// Output: 1
// Example 2:

// Input:
// 11000
// 11000
// 00100
// 00011

// Output: 3

// 直觉：把所有的1都设置为0
// 要点，难点：1. 不能回到原来的地方去，设置一个方法阻止其回到原来的地方去
// 2.如果 grid=‘0’，就退出循环
// 3.把用完的都设置为0
// 难点: 从头开始解把所有的可以被乘出来的数字全部都画为nonPrime
// 复杂度： O(n^2)
// 数据结构：Array

class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0) return 0;
        int row = grid[0].length, col = grid.length;
        int count = 0;
        boolean[][] used = new boolean[col][row];
        for(int i = 0; i < col; i++)
        {
            for(int j = 0; j < row; j++)
            {
                if(grid[i][j] == '1')
                {
                   used[i][j] = true;
                   dfs(i,j,col,row,grid,used); 
                   count++;

                }

            }
        }
        return count;
    }
    
    public void dfs(int i, int j, int n, int m, char[][] grid,boolean used[][])
    {      
        if(grid[i][j] == '0') return;
        used[i][j] = true;
        if(i+1 < n && used[i+1][j] == false)  dfs(i+1,j,n,m,grid,used);
        if(i-1 >= 0 && used[i-1][j] == false) dfs(i-1,j,n,m,grid,used);
        if(j+1 < m && used[i][j+1] == false)  dfs(i,j+1,n,m,grid,used);
        if(j-1 >= 0 && used[i][j-1] == false) dfs(i,j-1,n,m,grid,used);
        grid[i][j] = '0';

        
    }
}