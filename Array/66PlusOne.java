// 66. Plus One
// Given a non-empty array of digits representing a non-negative integer, plus one to the integer.

// The digits are stored such that the most significant digit is at the head of the list, and each element in the array contain a single digit.

// You may assume the integer does not contain any leading zero, except the number 0 itself.

// Example 1:

// Input: [1,2,3]
// Output: [1,2,4]
// Explanation: The array represents the integer 123.
// Example 2:

// Input: [4,3,2,1]
// Output: [4,3,2,2]
// Explanation: The array represents the integer 4321.

// 直觉：如果不进位，就退出，如果进位就把它设置为0，下一位看看是否还要进位，如果还要进位就继续换
// 要点，难点：1. 一位一位算，如果加好了直接return，没加好再看前面的，如果变成999+1，一定是1跟着3个0
// 归类：Array
// 难点: Array
// 复杂度： O(n)
// 数据结构：Array

class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;
        for(int i = n -1; i >= 0; i--)
        {
            if(digits[i] < 9)
            {
                digits[i]++;
                return digits;
            }
            digits[i] = 0;
        }
        
        int[] newNumber = new int[n+1];
        newNumber[0] = 1;
        return newNumber;


    }
}