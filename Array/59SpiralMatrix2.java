// 59. Spiral Matrix II
// Given a positive integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

// Example:
// Input: 3
// Output:
// [
//  [ 1, 2, 3 ],
//  [ 8, 9, 4 ],
//  [ 7, 6, 5 ]
// ]
// 直觉：设置墙，左边右边，上边下边，然后依次递减
// 要点，难点：1.写起来很麻烦，用for loop一步一步的把每一行每一列都写下来
// while判断是不是完全写完了
// 归类：Array
// 难点: Array
// 复杂度： O(n)
// 数据结构：dp
class Solution {
    public int[][] generateMatrix(int n) {
        int matrix[][] = new int[n][n];
        int top = 0;
        int buttom = n-1;
        int left = 0;
        int right = n-1;
        int count = 1;
        while(top <= buttom || left <= right)
        {

            for(int i = left; i <= right; i++)
            {
               matrix[top][i] = count++;
            }
            top++;

            for(int i = top; i <= buttom; i++)
            {
               matrix[i][right] = count++;  
            }
            right--;
            for(int i = right; i >= left; i--)
            {
                matrix[buttom][i] = count++;
            }
            buttom--;
            for(int i = buttom; i >= top;i--)
            {
                matrix[i][left] = count++;
            }
            left++;
        }
        
        return matrix;
    }
}