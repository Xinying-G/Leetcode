// 139. Word Break
// Medium
// Given a non-empty string s and a dictionary wordDict containing a list of non-empty words, determine if s can be segmented into a space-separated sequence of one or more dictionary words.

// Note:

// The same word in the dictionary may be reused multiple times in the segmentation.
// You may assume the dictionary does not contain duplicate words.
// Example 1:

// Input: s = "leetcode", wordDict = ["leet", "code"]
// Output: true
// Explanation: Return true because "leetcode" can be segmented as "leet code".
// Example 2:

// Input: s = "applepenapple", wordDict = ["apple", "pen"]
// Output: true
// Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
//              Note that you are allowed to reuse a dictionary word.
// Example 3:

// Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
// Output: false

// 一道DP的题，用dfs暴力解会遇到一个很难得testcase，一会儿再看

// 直觉：dfs
// 要点，难点：1.dfs 不能解决“aaaaaaaaa”，“aa”，“aaa” 。。。这种问题
// 2.这是我用dfs的暴力解，如果某一个单词对上了，就看下面的能否对上，如果都对上了直接返回true，如果对不上，看看其他组能不能对上
// 能对上再返回 true
// 归类：DP
// 难点: 如何找到数组之前和之后的关系
// 复杂度：O(n^n) 
// 数据结构：DFS

class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {

        return dfs(s, wordDict);
    }
    
    public boolean dfs(String s, List<String> wordDict)
    {
        boolean has = false;
        for(int i = 0; i < wordDict.size(); i++)
        {
            if(wordDict.get(i).length() <= s.length() && wordDict.get(i).equals(s.substring(0, wordDict.get(i).length())))
            { 
                if(wordDict.get(i).length() == s.length()) return true;
                if(dfs(s.substring(wordDict.get(i).length(),s.length()),wordDict)) has = true;                
            }
        }
        return has;
    }
}

// 直觉：DFS
// 要点，难点：1.如何找到dp数组之间的关系
// 2.设置一个数组，第一位为true，如果找到有这个单词，就把末位的后一位置设置为true，然后对于每一个末位char都寻找之前的是否有能让它完成一个单词，后一位为true的
// 如果这一位设置为true，代表一定可以到达这一位置，然后依次这样查找，直到最后一位，如果是true那就带便能够达到，如果不是那就达不到
// 归类：DP
// 难点: 如何找出DP的位置对应应该记录的问题
// 复杂度：O(n^2)
// 数据结构：DP
class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        boolean[] f = new boolean[s.length() + 1];
        f[0] = true;
                for(int i=1; i <= s.length(); i++){
            for(int j=0; j < i; j++){
                if(f[j] && wordDict.contains(s.substring(j, i))){
                    f[i] = true;
                    break;
                }
            }
        }
        
        return f[s.length()];
    }

}