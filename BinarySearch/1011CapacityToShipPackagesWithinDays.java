// 1011. Capacity To Ship Packages Within D Days
// A conveyor belt has packages that must be shipped from one port to another within D days.

// The i-th package on the conveyor belt has a weight of weights[i].  Each day, we load the ship with packages on the conveyor belt (in the order given by weights). We may not load more weight than the maximum weight capacity of the ship.

// Return the least weight capacity of the ship that will result in all the packages on the conveyor belt being shipped within D days.

 

// Example 1:

// Input: weights = [1,2,3,4,5,6,7,8,9,10], D = 5
// Output: 15
// Explanation: 
// A ship capacity of 15 is the minimum to ship all the packages in 5 days like this:
// 1st day: 1, 2, 3, 4, 5
// 2nd day: 6, 7
// 3rd day: 8
// 4th day: 9
// 5th day: 10

// Note that the cargo must be shipped in the order given, so using a ship of capacity 14 and splitting the packages into parts like (2, 3, 4, 5), (1, 6, 7), (8), (9), (10) is not allowed. 
// Example 2:

// Input: weights = [3,2,2,4,1,4], D = 3
// Output: 6
// Explanation: 
// A ship capacity of 6 is the minimum to ship all the packages in 3 days like this:
// 1st day: 3, 2
// 2nd day: 2, 4
// 3rd day: 1, 4

class Solution {
    public int shipWithinDays(int[] weights, int D) {
        //dp[i][j] = min(max(dp[i-1][k]),sum(num[k] +.... num[j]))
        // dynamic programming解法：
        // int[][] dp = new int[D][weights.length];
        // int[] sum = new int[weights.length];
        // sum[0] = weights[0];
        // dp[0][0] = sum[0];
        // for(int i = 1; i < weights.length; i++){
        //   sum[i] += weights[i] + sum[i-1];
        //   dp[0][i] = sum[i]; 
        // }
        // for(int i = 1; i < D; i++){
        //     for(int j = 0; j < weights.length; j++){
        //         dp[i][j] = Integer.MAX_VALUE;
        //         for(int k = 0; k < j; k++){
        //             dp[i][j] = Math.min(dp[i][j],Math.max(dp[i-1][k],sum[j] - sum[k]));
        //         }
        //     }
        // }
        // return dp[D-1][weights.length-1];
//         binarySearch解法
// 		Binary Search left 是最大值，right是sum的最大值
    	// 设限制最大为mid的话，看能分几组，分多了就left=mid+1，分少了就right=mid
        int left = 0, right = 0;
        for(int w: weights){
            left = Math.max(left,w);
            right += w;
        }
        while(left < right){
            int mid = (left + right)/2, need = 1, cur = 0;
            for(int w: weights){
                if(cur + w > mid){
                    need += 1;
                    cur = 0;
                }
                cur += w;   
            }
            if(need > D) left = mid+1;
            else right = mid;
        }
        return left;
    }
}