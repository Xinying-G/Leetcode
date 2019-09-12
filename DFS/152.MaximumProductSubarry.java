// 152. Maximum Product Subarray
// Given an integer array nums, find the contiguous subarray within an array (containing at least one number) which has the largest product.

// Example 1:

// Input: [2,3,-2,4]
// Output: 6
// Explanation: [2,3] has the largest product 6.

// 直觉：对于每一个负数的地方，求左边，右边 然后对比最大的
// 要点，难点：1. 记录包含这一个点的所能达到的最大值和所能达到的最小值，
// 如果下一个值是负数，下一个的最大可能是自己，或者自己乘以之前的最小，
// 如果下一个是正数那就比较之前的max和自己乘以之前的max
// 假设230240560 求最大的product
// 动态规划，记录每一个位置包含自己的最大，然后求最大
// 现在有负数，
// 动态规划，记录用这个位置数字可能的最大product和最小product，如果是负数，下一次
// 换一下
// 归类：BFS
// 难点: 许多个for循环
// 复杂度： O（n^n）
// 数据结构：BFS

class Solution {
    public int maxProduct(int[] nums) {
    
    if(nums.length == 0) return 0;
    int r = nums[0];
    for(int i = 1, imax = r,imin = r; i < nums.length; i++)
    {
        if(nums[i] < 0)
        {
            int tmp = imax;
            imax = imin;
            imin = tmp;
        }
        imax = Math.max(nums[i],nums[i]*imax);
        imin = Math.min(nums[i],nums[i]*imin);
        r = Math.max(r,imax);
    }
    return r;    
    }
}