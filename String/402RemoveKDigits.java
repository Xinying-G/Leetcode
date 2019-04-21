// 402. Remove K Digits
// Given a non-negative integer num represented as a string, remove k digits from the number so that the new number is the smallest possible.

// Note:
// The length of num is less than 10002 and will be ≥ k.
// The given num does not contain any leading zero.
// Example 1:

// Input: num = "1432219", k = 3
// Output: "1219"
// Explanation: Remove the three digits 4, 3, and 2 to form the new number 1219 which is the smallest.
// Example 2:

// Input: num = "10200", k = 1
// Output: "200"
// Explanation: Remove the leading 1 and the number is 200. Note that the output must not contain leading zeroes.

// 直觉：把前一位大于后一位的删掉前一位
// 要点，难点：1. 学会用stack
// 2.当遇到1234567890去掉9个数字的时候，需要去掉9之后去掉8，7，6 。。。 所以要用while
// 3. 合理运用stringbuider append和deleteCharAt和reverse
// 解决方法： 遇到前一位大于这一位的时候去掉前一位，如果没去完的话就把最后面的删掉，最后去掉前面的0，
// 注意coner case 只有0，k = 0，
// 归类：Stack
// 难点: Stack和Stringbuilder和如何找到最小数字
// 复杂度：O(n) 
// 数据结构：Stack

class Solution {
    public String removeKdigits(String num, int k) {
        if(num.length() == k) return "0";
        Stack<Character> stack = new Stack();

        for(int i = 0; i < num.length(); i++)
        {
            while(k > 0 && !stack.empty() && (stack.peek() > num.charAt(i)))
            {
                stack.pop();
                k--;
            }
            stack.push(num.charAt(i));       
        }
        
        while(k > 0)
        {
            stack.pop();
            k--;
        }
        
        StringBuilder sb = new StringBuilder();

        while(!stack.empty())
        {
            char a = stack.pop();
            sb.append(a);
        }
        sb.reverse();
        
        while(sb.length() > 1 && sb.charAt(0) == '0')
            sb.deleteCharAt(0);
        return sb.toString();
    }
}