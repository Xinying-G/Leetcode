// 73. Set Matrix Zeroes

// Given a m x n matrix, if an element is 0, set its entire row and column to 0. Do it in-place.

// Example 1:

// Input: 
// [
//   [1,1,1],
//   [1,0,1],
//   [1,1,1]
// ]
// Output: 
// [
//   [1,0,1],
//   [0,0,0],
//   [1,0,1]
// ]

// 直觉：设置一个matrix，然后看每一个地方是否是1
// 要点，难点：1. in-place， 用每一行的第一个和每一列的第一个储存是否是0，
// 单独储存第一列是否是0，不用单独储存第一行是否是0，因为第一行第一个数字储存了第一行是不是0
// 2.第二次loop要倒着遍历行，因为第一行记录了这一列是否为0的信息，不能随便改
// 3.如果这一列的col0是0，用完这一列之后把这个地方设置为0
// 归类：Array
// 难点: in-place
// 复杂度： O（nm）
// 数据结构：Array

class Solution {
    public void setZeroes(int[][] matrix) {
        int col0 = 1, row0 = 0, rows = matrix.length -1,
        cols = matrix[0].length -1;
        for(int i = 0; i <= rows; i++)
        {
            if(matrix[i][0] == 0) col0 = 0;
            for(int j = 1; j <= cols; j++)
            {
                if(matrix[i][j] == 0)
                {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                }
            }
        }
        
        for(int i = rows; i >= 0; i--)
        {
            for(int j = 1; j <= cols; j++)
            {
                if(matrix[i][0] == 0 || matrix[0][j] == 0)
                    matrix[i][j] = 0;
            }
            if(col0 == 0) matrix[i][0] = 0;
        }
    }
}