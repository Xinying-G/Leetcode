// 91. Decode Ways
// A message containing letters from A-Z is being encoded to numbers using the following mapping:

// 'A' -> 1
// 'B' -> 2
// ...
// 'Z' -> 26
// Given a non-empty string containing only digits, determine the total number of ways to decode it.

// Example 1:

// Input: "12"
// Output: 2
// Explanation: It could be decoded as "AB" (1 2) or "L" (12).
// Example 2:

// Input: "226"
// Output: 3
// Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).

// 直觉：DFS
// 要点，难点：1. 如果这个位置的数字可以用，就dfs（i+1）
// 2。检查这一位数字和下一位置数字可不可以用，如果可以就dfs（i+2）
// 如果遇到第一位置是0，那就证明走不下去，退出
// 问题：有大的case时间太多，过不去
// 归类：DFS
// 难点: 1.‘0’
// 复杂度： O（n^2）
// 数据结构：DFS

class Solution {
    int res = 0;
    public int numDecodings(String s) {
        dfs(s, 0);
        return res;
    }
    
    public void dfs(String s, int start)
    {
        if(s.length() == start) {res++; return;}
        if(s.charAt(start) == '0') return;
        if(s.length() -1 == start){res++; return;}
        if(Integer.parseInt(s.substring(start,start+2)) <= 26 && Integer.parseInt(s.substring(start,start+2)) > 0)
            dfs(s,start+2);
        if(Integer.parseInt(s.substring(start,start+1)) > 0) dfs(s,start+1);
    }
}

// 直觉：DP
// 要点，难点：1. 如果这一位置的数字可以用，dp[i+1]+= dp[i],
// 如果这一位置和前一位数字可以用，dp[i+1] += dp[i-1],
// 2.要小心0的情况，如果这一位置为0，不能做dp[i+1]+= dp[i]
// 如果前一位置是0，不能做dp[i+1]+= dp[i-1]，如果连起来的数字超出26，也不能做
// 问题：
// 归类：DP
// 难点: 1.‘0’
// 复杂度： O（n）
// 数据结构：DP

class Solution {
    int res = 0;
    public int numDecodings(String s) {
        int[] dp = new int[s.length()+1];
        dp[0] = 1;
        for(int i = 0; i < s.length(); i++)
        {
            if(s.charAt(i) != '0') dp[i+1] += dp[i];
            if( i-1 >= 0 && s.charAt(i-1) != '0' && 
               Integer.parseInt(s.substring(i-1,i+1)) <= 26)
                dp[i+1] += dp[i-1];
            System.out.println(dp[i+1]);
        }
        return dp[s.length()];
    }

}