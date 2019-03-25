// 解决方法：1.dfs if find return true, else return flase
// 直觉：同解决方法 
// 要点，难点：1.dsf 遇到comb长度和k一样就返回
// 归类：算法一类 Permutation/backtracking
// 难点: bakctracking 到底要在什么地方new 并且输入dfs要输入i 不是index
// 复杂度： O(n)
// 数据结构：dfs
import java.lang.StringBuilder;
import java.util.*;

public class wordSearch
{
    static boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        visited = new boolean[board.length][board[0].length];
        
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if((word.charAt(0) == board[i][j]) && search(board, word, i, j, 0)){
                    return true;
                }
            }
        }
        
        return false;
    }

    private boolean search(char[][]board, String word, int i, int j, int index){
        if(index == word.length()){
            return true;
        }
        
        if(i >= board.length || i < 0 || j >= board[i].length || j < 0 || board[i][j] != word.charAt(index) || visited[i][j]){
            return false;
        }
        
        visited[i][j] = true;
        if(search(board, word, i-1, j, index+1) || 
           search(board, word, i+1, j, index+1) ||
           search(board, word, i, j-1, index+1) || 
           search(board, word, i, j+1, index+1)){
            return true;
        }
        
        visited[i][j] = false;
        return false;
    }
}
