// 150. Evaluate Reverse Polish Notation
// Evaluate the value of an arithmetic expression in Reverse Polish Notation.
// Valid operators are +, -, *, /. Each operand may be an integer or another expression.
// Note:

// Division between two integers should truncate toward zero.
// The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
// Example 1:

// Input: ["2", "1", "+", "3", "*"]
// Output: 9
// Explanation: ((2 + 1) * 3) = 9
// Example 2:

// Input: ["4", "13", "5", "/", "+"]
// Output: 6
// Explanation: (4 + (13 / 5)) = 6
// Example 3:

// Input: ["10", "6", "9", "3", "+", "-11", "*", "/", "*", "17", "+", "5", "+"]
// Output: 22
// Explanation: 
//   ((10 * (6 / ((9 + 3) * -11))) + 17) + 5
// = ((10 * (6 / (12 * -11))) + 17) + 5
// = ((10 * (6 / -132)) + 17) + 5
// = ((10 * 0) + 17) + 5
// = (0 + 17) + 5
// = 17 + 5
// = 22

// 直觉：Stack
// 要点，难点：1. 用Stack，如果遇到加减乘除就pop出来再把结果放进去
// 归类：Stack
// 难点: 如果只有一个numer怎么办，那就pop出来
// 复杂度： O（n）
// 数据结构：Stack
class Solution {
    public int evalRPN(String[] tokens) {
        Stack<Integer> nums = new Stack<Integer>();
        int res = 0;
        for(int i = 0; i < tokens.length; i++)
        {
            if(tokens[i].equals("+"))
            {
                res = nums.pop()+nums.pop();
                nums.push(res);
            }
            else if(tokens[i].equals("-"))
            {
                int n1 = nums.pop(), n2 = nums.pop();
                res = n2-n1;
                nums.push(res);
            }
            else if(tokens[i].equals("*"))
            {
                res = nums.pop()*nums.pop();
                nums.push(res);
            }
            else if(tokens[i].equals("/"))
            {
               int n1 = nums.pop(), n2 = nums.pop();
               res = n2/n1;
               nums.push(res);
            }
            else 
                nums.push(Integer.parseInt(tokens[i]));
        }
        
        return res == 0? nums.pop():res;
    }
}