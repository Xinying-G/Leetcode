// 227. Basic Calculator II
// Implement a basic calculator to evaluate a simple expression string.

// The expression string contains only non-negative integers, +, -, *, / operators and empty spaces . The integer division should truncate toward zero.

// Example 1:

// Input: "3+2*2"
// Output: 7


//这道题关键在于sign要在num之前，然后stack里面只放num加减
// 最后一位一般应该是数字，这个时候就要把它也做一下运算
class Solution {
    public int calculate(String s) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        int len;
        if(s == null || (len = s.length()) == 0) return 0;
        char sign = '+';
        for(int i = 0; i < len; i++)
        {
            if(Character.isDigit(s.charAt(i)))
            {
                num = num*10 + (s.charAt(i) - '0');
            }
            
            if((!Character.isDigit(s.charAt(i)) && ' ' != s.charAt(i)) || i == len -1)
            {
                if(sign == '+')
                    stack.push(num);
                if(sign == '-')
                    stack.push(-num);
                if(sign == '*')
                    stack.push(stack.pop()*num);
                if(sign == '/')
                    stack.push(stack.pop()/num);
                sign = s.charAt(i);
                num = 0;
            }   
        }
        
        int res = 0;
        for(int r: stack)
        {
            res += r;
        }
        return res;
    }
}
