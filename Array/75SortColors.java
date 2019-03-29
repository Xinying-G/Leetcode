// 75. Sort Colors
// Given an array with n objects colored red, white or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white and blue.

// Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

// Note: You are not suppose to use the library's sort function for this problem.

// Example:

// Input: [2,0,2,1,1,0]
// Output: [0,0,1,1,2,2]

// 直觉：quicksort partition，zeros 的位置是0的位置的后一位，two的位置是是2的位置的前一位，设置zeros = 0， two = end
// 然后遍历，如果index数字=0，就把该把zero和index的位置的数字交换，zeros++，index数字=2，就把two和index的位置的数字交换，two--，
// 但是交换过来的，index的位置的数字不确定是几，所以我们要再检查这个index的位置的数字。如果index = 1，就跳过不动，对于nums[index] == 0 没必要
// 因为交换过来的nums[index]不是0，就是1，不然过不来。
// 要点，难点：要一个loop完成，需要用3 partition
// 1. 3 pointer partition
// 2.如果遇到index是2，换过来还要再判断是不是2，如果换过来的index是0，那么就没必要换，因为zero位置的肯定会再过到index的位置。
// 归类：Array
// 难点: 1.Quick Sort partition
// 复杂度： O（n）
// 数据结构：Quick Sort partition

class Solution {
    public void sortColors(int[] nums) {
        int zero = 0, index = 0, two = nums.length -1;
        while(index <= two)
        {
            if(nums[index] == 0)
                swap(index,zero++,nums);
            if(nums[index] == 2)
                swap(index--,two--,nums);
            index++;
        }
    }
    
    public void swap(int a, int b, int[] nums)
    {
        int tmp = nums[a];
        nums[a] = nums[b];
        nums[b] = tmp;
    }
}