// 53. Maximum Subarray
// Given an integer array nums, find the contiguous subarray (containing at least one number) which has the largest sum and return its sum.

// Example:

// Input: [-2,1,-3,4,-1,2,1,-5,4],
// Output: 6
// Explanation: [4,-1,2,1] has the largest sum = 6.
// Follow up:

// If you have figured out the O(n) solution, try coding another solution using the divide and conquer approach, which is more subtle.
// solution 1: if previous sum is negaive, begin from a new number, else, sum next number, find the biggest sum. (easy method)
// 直觉：不会 
// 要点，难点：1.前面加起来如果是负数就抛弃，从新一位开始
// 2. 从新一位开始
// 归类：Array
// 难点: Array
// 复杂度： O(n)
// 数据结构：for loop
class Solution {
    public int maxSubArray(int[] nums) {
        int sum = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(sum < 0){
                sum = nums[i];
                
            }
            else
                sum = sum + nums[i];
            max = Math.max(sum,max);
        }
        return max;
    }
}

// Dnamic Programming method
// 直觉：这一位数字max（max（n-1），n）但是无法找出n位置链接之前的最大数字
// 要点，难点：1.dp【】的位置上记录了运行到这一步的数值，根据我们的算法，是连接本位置的最大的值
// 2.如何计算本位的最大值？ 如果包含前一位的最大值是负数，那么我们就从本位置开始
// 归类：DP
// 难点: DP
// 复杂度： O(n)
// 数据结构：for loop
class Solution {
    public int maxSubArray(int[] nums) {
        
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        int max = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            dp[i] = nums[i] + (dp[i-1] > 0? dp[i-1]:0);
            max  = Math.max(dp[i],max);
        }
        return max;
    }
}

