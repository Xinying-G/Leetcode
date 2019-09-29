// 482. License Key Formatting
// You are given a license key represented as a string S which consists only alphanumeric character and dashes. The string is separated into N+1 groups by N dashes.

// Given a number K, we would want to reformat the strings such that each group contains exactly K characters, except for the first group which could be shorter than K, but still must contain at least one character. Furthermore, there must be a dash inserted between two groups and all lowercase letters should be converted to uppercase.

// Given a non-empty string S and a number K, format the string according to the rules described above.

// Example 1:
// Input: S = "5F3Z-2e-9-w", K = 4

// Output: "5F3Z-2E9W"

// Explanation: The string S has been split into two parts, each part has 4 characters.
// Note that the two extra dashes are not needed and can be removed.
// Example 2:
// Input: S = "2-5g-3-J", K = 2

// Output: "2-5G-3J"

// Explanation: The string S has been split into three parts, each part has 2 characters except the first part as it could be shorter as mentioned above.
// Note:
// The length of string S will not exceed 12,000, and K is a positive integer.
// String S consists only of alphanumerical characters (a-z and/or A-Z and/or 0-9) and dashes(-).
// String S is non-empty.

// 直觉：String的题，一看需要reverse一下，去掉-，toUpperCase，再加上-，再reverse回来
// 要点，难点：做的时候index没有梳理清晰，counter负责数走过的char，ind负责添加‘-’
// 每一次添加‘-’，ind都++，然后跳到字符那边，然后继续数
// 归类：String
// 难点: insert的时候的index
// 复杂度： O（n）
// 数据结构：StringBuilder
class Solution {

class Solution {
    public String licenseKeyFormatting(String S, int K) {
        StringBuilder sb = new StringBuilder(S.replaceAll("-","").toUpperCase()).reverse();
        int counter = 1;
        int i = 0;
        while(i < sb.length())
        {
            if(counter%K == 0 && i != sb.length()-1)
            {
                sb.insert(++i,'-');
            }
            i++;
            counter++;
        }
        // System.out.println(S1);
        return sb.reverse().toString();
    }
}