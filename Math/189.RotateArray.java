// 189. Rotate Array
// Given an array, rotate the array to the right by k steps, where k is non-negative.

// Example 1:

// Input: [1,2,3,4,5,6,7] and k = 3
// Output: [5,6,7,1,2,3,4]
// Explanation:
// rotate 1 steps to the right: [7,1,2,3,4,5,6]
// rotate 2 steps to the right: [6,7,1,2,3,4,5]
// rotate 3 steps to the right: [5,6,7,1,2,3,4]

// 直觉：直接交换，结果发现最后几位和前面几位交换得到的结果是不正确的，是要推后面几位去前面才好
// 要点，难点：1. reverse前面的，再reverse后面的，再reverse整个序列
// 我们要reverse的是后面的k个和前面的剩下的，如果我们reverse整个序列，会发现后面的k个跑到前边但是是倒序，所以我们把倒序的数字reverse回来
// 2. K可以大于nums.length
// 归类：Math
// 难点: 1.Reverse
// 复杂度： O（n）
// 数据结构：Math

class Solution {
    public void rotate(int[] nums, int k) {
        k %= nums.length;
        reverse(0, nums.length-k-1, nums);
        reverse(nums.length-k, nums.length-1, nums);
        reverse(0,nums.length-1, nums);
    }
    
    public void reverse(int start, int end, int[]nums)
    {
        while(start < end)
        {
            int tmp = nums[start];
            nums[start] = nums[end];
            nums[end] = tmp;
            start++; end--;
        }
    }
}