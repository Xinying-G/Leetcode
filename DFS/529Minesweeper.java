// 529. Minesweeper
// Let's play the minesweeper game (Wikipedia, online game)!

// You are given a 2D char matrix representing the game board. 'M' represents an unrevealed mine, 'E' represents an unrevealed empty square, 'B' represents a revealed blank square that has no adjacent (above, below, left, right, and all 4 diagonals) mines, digit ('1' to '8') represents how many mines are adjacent to this revealed square, and finally 'X' represents a revealed mine.

// Now given the next click position (row and column indices) among all the unrevealed squares ('M' or 'E'), return the board after revealing this position according to the following rules:

// If a mine ('M') is revealed, then the game is over - change it to 'X'.
// If an empty square ('E') with no adjacent mines is revealed, then change it to revealed blank ('B') and all of its adjacent unrevealed squares should be revealed recursively.
// If an empty square ('E') with at least one adjacent mine is revealed, then change it to a digit ('1' to '8') representing the number of adjacent mines.
// Return the board when no more squares will be revealed.
 

// Example 1:

// Input: 

// [['E', 'E', 'E', 'E', 'E'],
//  ['E', 'E', 'M', 'E', 'E'],
//  ['E', 'E', 'E', 'E', 'E'],
//  ['E', 'E', 'E', 'E', 'E']]

// Click : [3,0]

// Output: 

// [['B', '1', 'E', '1', 'B'],
//  ['B', '1', 'M', '1', 'B'],
//  ['B', '1', '1', '1', 'B'],
//  ['B', 'B', 'B', 'B', 'B']]

// Explanation:

// Example 2:

// Input: 

// [['B', '1', 'E', '1', 'B'],
//  ['B', '1', 'M', '1', 'B'],
//  ['B', '1', '1', '1', 'B'],
//  ['B', 'B', 'B', 'B', 'B']]

// Click : [1,2]

// Output: 

// [['B', '1', 'E', '1', 'B'],
//  ['B', '1', 'X', '1', 'B'],
//  ['B', '1', '1', '1', 'B'],
//  ['B', 'B', 'B', 'B', 'B']]

// Explanation:

 

// Note:

// The range of the input matrix's height and width is [1,50].
// The click position will only be an unrevealed square ('M' or 'E'), which also means the input board contains at least one clickable square.
// The input board won't be a stage when game is over (some mines have been revealed).
// For simplicity, not mentioned rules should be ignored in this problem. For example, you don't need to reveal all the unrevealed mines when the game is over, consider any cases that you will win the game or flag any squares.

// 直觉：recursion,
// 要点，难点：遇到bug很难debug
// 每一次添加‘-’，ind都++，然后跳到字符那边，然后继续数
// 解决方法：对于一脚踩到雷的直接换成X，返回，如果不是，进行reveal的recursion，如果一脚踩到附近有雷的，显示数字
// 如果不是写B，然后recursion周围的8个，对每一个进行附近排查，如果附近有雷的写数字，本位是雷的什么都不做也不recursion，
// 不然就recursion
// 归类：DFS
// 难点: 需要设置一个used以防止recursion重新计算原来计算过的
// 复杂度： O（nm）
// 数据结构：DFS

class Solution {
    public char[][] updateBoard(char[][] board, int[] click) {
        if(board[click[0]][click[1]] == 'M')
        {
            board[click[0]][click[1]] = 'X';
            return board;
        }
        boolean[][] used = new boolean[board.length][board[0].length];
        reveal(board,click[0],click[1],used);
        return board;
    }
    
    public void reveal(char[][] board,int row, int col,boolean[][] used)
    {
        // System.out.println(row + "" + col);
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0 || used[row][col])
            return;
        used[row][col] = true;
        if(board[row][col] == 'M' || Character.isDigit(board[row][col])) return;
        int digit = checkDigits(board,row-1,col-1) + checkDigits(board,row,col-1) + checkDigits(board,row+1,col-1) + checkDigits(board,row-1,col) + checkDigits(board,row+1,col) + checkDigits(board,row-1,col+1) + checkDigits(board,row,col+1) + checkDigits(board,row+1,col+1);
        if(digit != 0){
            board[row][col] = (char)(digit + '0');
        }
        else {
            board[row][col] = 'B';
            reveal(board,row-1,col-1,used);
            reveal(board,row,col-1,used);
            reveal(board,row+1,col-1,used);
            reveal(board,row-1,col,used);
            reveal(board,row+1,col,used);
            reveal(board,row-1,col+1,used);
            reveal(board,row,col+1,used);
            reveal(board,row+1,col+1,used);
        }
    }
    
    public int checkDigits(char[][] board, int row, int col)
    {
        if(row >= board.length || row < 0 || col >= board[0].length || col < 0)
            return 0;
        if(board[row][col] == 'M') return 1;
        return 0;
    }
}






