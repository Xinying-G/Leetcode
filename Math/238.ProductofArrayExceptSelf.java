// 238. Product of Array Except Self
// Given an array nums of n integers where n > 1,  return an array output such that output[i] is equal to the product of all the elements of nums except nums[i].

// Example:

// Input:  [1,2,3,4]
// Output: [24,12,8,6]

// 直觉：左边的乘右边的，用两个数组
// 要点，难点：1. 用一个数组做
// 2.直接用一个right，然后从右到左乘右边的数字
// 解决方法： 设置一个数组res，这个数组的每个位置为从左边乘起到i-1的值，设置一个right的int
// right = 右边end乘到i+1的值，然后挨个乘以res的值就是
// 归类：Math
// 难点: 难想如何解决左边右边的问题
// 复杂度：O（n）
// 数据结构：Math

class Solution {
    public int[] productExceptSelf(int[] nums) {
        int n = nums.length;
        int[] res = new int[n];
        res[0] = 1;
        for(int i = 1; i < n; i++)
        {
            res[i] = res[i-1]*nums[i-1];
        }
        int right = 1;
        for(int i = n-1; i >= 0; i--)
        {
            res[i] = res[i]*right;
            right = right*nums[i];
        }
        
        return res; 
    }
}