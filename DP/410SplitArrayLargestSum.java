// 410. Split Array Largest Sum
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

// 直觉：动态规划问题
// 解题方法：用dp记录每一个点的最小最大和，最小最大和 = min{max{dp[i-1][k],sum(j->k)}}
// 难点：难以想出dp的解决方法
// 数据结构：
// 复杂度：O（n^3）

Class Solution{
	// 7,2,5,10,8
	//7,2,5, 10,8
	public static int largestSum(int[] nums, int m){
		if(nums == null) return -1;
		int[][] dp = new int[m][nums.length];
		dp[0][0] = nums[0];
		for(int i = 1; i < nums.length; i++){
			dp[0][i] = dp[0][i-1]+nums[i];
		}

		for(int i = 1; i < m, i++){
			for(int j = 1; j < nums.length; j++){
				dp[i][j] = Integer.MAX_VALUE;
				for(int k = 0; k < j; k++){
					dp[i][j] = Math.min(dp[i][j],Math.max(dp[i-1][k],dp[0][j] - dp[0][k]))
				}
			}
		}
		return dp[m-1][nums.length-1];
	}

	public static void main(String[] args){
		int[] nums = new int[]{7,2,5,10,8};
	 	int res = largestSum(nums,2);
	}
}

