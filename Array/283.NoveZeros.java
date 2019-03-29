// 283. Move Zeroes
// Given an array nums, write a function to move all 0's to the end of it while maintaining the relative order of the non-zero elements.

// Example:

// Input: [0,1,0,3,12]
// Output: [1,3,12,0,0]

// 直觉：设置一个指针，然后遍历每一个element，如果这个element不为0，
// 那么就填写在这个指针位置，然后指针++
// 要点，难点：
// 归类：Array
// 难点: 
// 复杂度： O（n）
// 数据结构：Array

class Solution {
    public void moveZeroes(int[] nums) {
        int t1 = 0;
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[i] != 0){nums[t1] = nums[i]; t1++;}         
        }
        while(t1 < nums.length) {
            nums[t1] = 0;
            t1++;
        }
    }
}