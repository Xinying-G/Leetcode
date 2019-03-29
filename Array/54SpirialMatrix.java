// 54. Spiral Matrix
// Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

// Example 1:

// Input:
// [
//  [ 1, 2, 3 ],
//  [ 4, 5, 6 ],
//  [ 7, 8, 9 ]
// ]
// Output: [1,2,3,6,9,8,7,4,5]

// 直觉：直觉是对的但是因为判断什么时候break没判断出来
// 要点，难点：1. spiralMatrix的spiral什么时候停止
// 归类：Math
// 难点: 1.spiralMatrix的spiral什么时候停止
// 复杂度： O（n）
// 数据结构：Array
class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> res = new ArrayList<>();
        if(matrix.length == 0)
            return res;

        int top = 0;
        int bottom = matrix.length-1;
        int left = 0;
        int right = matrix[0].length-1;
        while(true)
        {
            for(int i = left; i <= right; i++)
            {
                res.add(matrix[top][i]);
            }  
            top++;
            if(left > right || top > bottom) break;
            for(int i = top; i <= bottom; i++)
            {
                res.add(matrix[i][right]);
            } 
            right--;
             if(left > right || top > bottom) break;
            for(int i = right; i >= left; i--)
            {
                res.add(matrix[bottom][i]);
            }
            bottom--;
             if(left > right || top > bottom) break;
            for(int i = bottom; i >= top; i--)
            {
                res.add(matrix[i][left]);
            }
            left++;
             if(left > right || top > bottom) break;
        }
        return res;
    }
    
};