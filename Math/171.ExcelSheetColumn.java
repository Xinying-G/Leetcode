// 171. Excel Sheet Column Number
// Given a column title as appear in an Excel sheet, return its corresponding column number.

// For example:

//     A -> 1
//     B -> 2
//     C -> 3
//     ...
//     Z -> 26
//     AA -> 27
//     AB -> 28 
//     ...

// 直觉：反复相加
// 要点，难点：1. 其实就是26进制，想象一下10进制， 前一位11 = 1*10 +1
// 归类：Math
// 难点: 1.其实等于十进制
// 复杂度： O（n）
// 数据结构：Math
class Solution {
    public int titleToNumber(String s) {
        int res = 0;
        for(int i = 0; i < s.length(); i++)
        {
            res = res*26 + (s.charAt(i) - 'A'+1);
        }
        return res;
    }
}