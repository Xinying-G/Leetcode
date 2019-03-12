// 28. Implement strStr()
// Implement strStr().
// Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

// Example 1:

// Input: haystack = "hello", needle = "ll"
// Output: 2
// Example 2:

// Input: haystack = "aaaaa", needle = "bba"
// Output: -1
// Clarification:

// What should we return when needle is an empty string? This is a great question to ask during an interview.

// For the purpose of this problem, we will return 0 when needle is an empty string. This is consistent to C's strstr() and Java's indexOf().

// when needle is "", return 0, else when haystack = "" return -1

// 直觉：double pointer
// 要点，难点：1. 
// 归类：double pointer
// 难点: when needle is "", return 0,因此我们不能用 i < haystack.length(), 如果 needle 的长度是 “”，那么return0，如果haystack的长度是
// 空，那么看i，j的长度，如果j=0，i=0，haystack.length=0, needle=1 返回-1
// 复杂度： O（n+m）
// 数据结构：2 pointer

class Solution {
    public int strStr(String haystack, String needle) {    
        for(int i = 0; ; i++)
        {
            for(int j = 0; ; j++)
            {
                if(j == needle.length()) return i;
                if(i+j == haystack.length()) return -1;
                if(haystack.charAt(i+j) != needle.charAt(j)) break;
            }
        }

    }
}
