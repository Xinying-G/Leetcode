// 36. Valid Sudoku
// Medium
// Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:

// Each row must contain the digits 1-9 without repetition.
// Each column must contain the digits 1-9 without repetition.
// Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.

// A partially filled sudoku which is valid.

// The Sudoku board could be partially filled, where empty cells are filled with the character '.'.

// Example 1:

// Input:
// [
//   ["5","3",".",".","7",".",".",".","."],
//   ["6",".",".","1","9","5",".",".","."],
//   [".","9","8",".",".",".",".","6","."],
//   ["8",".",".",".","6",".",".",".","3"],
//   ["4",".",".","8",".","3",".",".","1"],
//   ["7",".",".",".","2",".",".",".","6"],
//   [".","6",".",".",".",".","2","8","."],
//   [".",".",".","4","1","9",".",".","5"],
//   [".",".",".",".","8",".",".","7","9"]
// ]
// Output: true
// Example 2:

// Input:
// [
//   ["8","3",".",".","7",".",".",".","."],
//   ["6",".",".","1","9","5",".",".","."],
//   [".","9","8",".",".",".",".","6","."],
//   ["8",".",".",".","6",".",".",".","3"],
//   ["4",".",".","8",".","3",".",".","1"],
//   ["7",".",".",".","2",".",".",".","6"],
//   [".","6",".",".",".",".","2","8","."],
//   [".",".",".","4","1","9",".",".","5"],
//   [".",".",".",".","8",".",".","7","9"]
// ]
// Output: false
// Explanation: Same as Example 1, except with the 5 in the top left corner being 
//     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
// Note:

// A Sudoku board (partially filled) could be valid but is not necessarily solvable.
// Only the filled cells need to be validated according to the mentioned rules.
// The given board contain only digits 1-9 and the character '.'.
// The given board size is always 9x9.

// 直觉：很难读懂题意
// 要点，难点：用Hashset去检测是在这一行或者这一列中有重复的，
// 解决方法：对每一个元素进行行列和小格子的编码，然后放入hashset，如果有重复的元素就宣告false
// 归类：HashSet
// 难点: 编码每一个位置的元素
// 复杂度： O（n）
// 数据结构：HashSet

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int num = 9;
        Set<String> has = new HashSet<>();
        for(int i = 0; i < num; i++)
        {
            for(int j = 0; j < num; j++)
            {
                if(board[i][j] != '.'){
                    String row = "r" + board[i][j] + String.valueOf(i);               
                    String col = "c" + board[i][j] + String.valueOf(j);
                    String squ = "s" + board[i][j] + String.valueOf(i/3)+String.valueOf(j/3);
                    if(!has.add(row) || !has.add(col) || !has.add(squ))
                        return false;
                }

            }
        }
        return true;      
    }
}