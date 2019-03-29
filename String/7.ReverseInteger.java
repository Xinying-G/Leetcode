// 7. Reverse Integer
// Given a 32-bit signed integer, reverse digits of an integer.

// Example 1:

// Input: 123
// Output: 321

class Solution {
    public int reverse(int x) {
        int res = 0;
        while(x != 0)
        {
            if(res > Integer.MAX_VALUE/10 || res < Integer.MIN_VALUE/10) return 0;
            res *=10;
            res += x%10;
            x /= 10;
        }
        return res;
    }
}