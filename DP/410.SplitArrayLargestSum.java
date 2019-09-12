// 410. Split Array Largest Sum
// Hard

// 955

// 53

// Favorite

// Share
// Given an array which consists of non-negative integers and an integer m, you can split the array into m non-empty continuous subarrays. Write an algorithm to minimize the largest sum among these m subarrays.

// Note:
// If n is the length of array, assume the following constraints are satisfied:

// 1 ≤ n ≤ 1000
// 1 ≤ m ≤ min(50, n)
// Examples:

// Input:
// nums = [7,2,5,10,8]
// m = 2

// Output:
// 18

// Explanation:
// There are four ways to split nums into two subarrays.
// The best way is to split it into [7,2,5] and [10,8],
// where the largest sum among the two subarrays is only 18.

class Solution {
    public int splitArray(int[] nums, int m) {
        // dp[i][j] = min(dp[i-1][k],sum(k->j)) k=(0->j-1)
        // dp[i][j] 是0->j分i份的minimized最大和，等于最小化从{0->k分j-1份, sum(k->i)}的最大和
        // 等于min{dp[i-1][k],sum(k->j)}
        if(nums == null) return -1;
        int[][] dp = new int[m][nums.length];
        dp[0][0] = nums[0];
        for(int i = 1; i < dp[0].length; i++){
            dp[0][i] = dp[0][i-1] + nums[i];
        }
        for(int i = 1; i < m; i++){
            for(int j = 0; j < nums.length; j++){
                dp[i][j] = Integer.MAX_VALUE;
                for(int k = 0; k < j; k++){
                    dp[i][j] = Math.min(dp[i][j],Math.max(dp[i-1][k],dp[0][j] - dp[0][k]));
                }
            }
        }
        return dp[m-1][nums.length-1];
    }
}