// 1055. Shortest Way to Form String
// From any string, we can form a subsequence of that string by deleting some number of characters (possibly no deletions).

// Given two strings source and target, return the minimum number of subsequences of source such that their concatenation equals target. If the task is impossible, return -1.

 

// Example 1:

// Input: source = "abc", target = "abcbc"
// Output: 2
// Explanation: The target "abcbc" can be formed by "abc" and "bc", which are subsequences of source "abc".
// Example 2:

// Input: source = "abc", target = "acdbc"
// Output: -1
// Explanation: The target string cannot be constructed from the subsequences of source string due to the character "d" in target string.

// source和target做比对，如果比对对了，如果source到头了就新开一遍，如果比对一遍j没动就说明对不上
class Solution {
    public int shortestWay(String source, String target) {
        int need = 0;
        int i = 0, j = 0;
        while(j < target.length()){
            int start = j;
            while(i < source.length() && j < target.length()){
                if(source.charAt(i) == target.charAt(j)){
                    i++;j++;
                }
                else i++;
            }
            if(j == start) return -1;
            need += 1;
            i = 0;
        }
       return need; 
    }
}