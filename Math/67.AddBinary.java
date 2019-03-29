// 67. Add Binary
// Given two binary strings, return their sum (also a binary string).

// The input strings are both non-empty and contains only characters 1 or 0.

// Example 1:

// Input: a = "11", b = "1"
// Output: "100"
// Example 2:

// Input: a = "1010", b = "1011"
// Output: "10101"

// 直觉：String的每一个char都做对比
// 要点，难点：1. StringBuilde reverse, append的方法，
// 2. 没必要分情况讨论，如果一个加完了那就让他加完好了，still有carry的可能性
// 归类：Math
// 难点: 1.StringBuilder
// 复杂度： O（n）
// 数据结构：Array

class Solution {
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        int la = a.length()-1, lb = b.length()-1, carry = 0;
        while(la >= 0 || lb >= 0)
        {
            int sum = carry;
            if(la >= 0) sum += a.charAt(la--) - '0';
            if(lb >= 0) sum += b.charAt(lb--) - '0';
            carry = sum/2;
            sb.append(sum%2);
        }
        if(carry != 0) sb.append('1');
        return sb.reverse().toString();
    }
}