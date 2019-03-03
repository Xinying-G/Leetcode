// 55. Jump Game
// Given an array of non-negative integers, you are initially positioned at the first index of the array.

// Each element in the array represents your maximum jump length at that position.

// Determine if you are able to reach the last index.

// Example 1:

// Input: [2,3,1,1,4]
// Output: true
// Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
// Example 2:

// Input: [3,2,1,0,4]
// Output: false
// Explanation: You will always arrive at index 3 no matter what. Its maximum
//              jump length is 0, which makes it impossible to reach the last index.
// 直觉：同解决方法 
// 要点，难点：1.要先研究一下dp问题的应该放什么
// 归类：Array,DP
// 难点: Array,Dp Dp最大的难点就是找不到dp array里面该放啥，该怎么计算这个array里面的内容，
// 我们dp里面放的是计算到这里，最远能达到的距离，如果大于等于这个距离，代表能走到最后，小于就代表走不到
// 复杂度： O(n)
// 数据结构：dp
class Solution {
    public boolean canJump(int[] nums) {
        if(nums == null || nums.length == 0)
            return false;
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        for(int i = 1; i < nums.length; i++)
        {
            if(i <= dp[i-1])
                dp[i] = Math.max(dp[i-1],nums[i]+i);
            else return false;
        }
        if(dp[nums.length-1] >= nums.length -1)
            return true;
        return false;
    }
}