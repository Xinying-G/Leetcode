// 837. New 21 Game
// Alice plays the following game, loosely based on the card game "21".

// Alice starts with 0 points, and draws numbers while she has less than K points.  During each draw, she gains an integer number of points randomly from the range [1, W], where W is an integer.  Each draw is independent and the outcomes have equal probabilities.

// Alice stops drawing numbers when she gets K or more points.  What is the probability that she has N or less points?

// Example 1:

// Input: N = 10, K = 1, W = 10
// Output: 1.00000
// Explanation:  Alice gets a single card, then stops.
// Example 2:

// Input: N = 6, K = 1, W = 10
// Output: 0.60000
// Explanation:  Alice gets a single card, then stops.
// In 6 out of W = 10 possibilities, she is at or below N = 6 points.
// Example 3:

// Input: N = 21, K = 17, W = 10
// Output: 0.73278


class Solution {
    public double new21Game(int N, int K, int W) {
        if(K == 0 || N >= K+W) return 1.0;
        double[] dp = new double[N+1];
        dp[0] = 1;
        double Wsum = 1, res = 0;
//         f(x) = 1/W*(f(x-1),f(x-2),...f(x-W))
//  if(x < W) f(x) = 1/W*(f(x-1)...f(0))
//  dp[0] = 1, dp[1] = 1/W(dp[0]), dp[2] = (dp[1]+dp[0]) * 1/W, dp[3] = 1/W*(dp[1]+dp[2] + dp[0])...
//         dp[i] = 1/W*(dp[i-W]+....dp[i-1])
//         dp[i] = Wsum
//  if(i >= W )Wsum - dp[i-W] 
//         dp[k]; dp[k+1]
        for(int i = 1; i <= N; i++){
            dp[i] = Wsum/W;
            if(i < K) Wsum += dp[i]; else res += dp[i];
            // 如果>k 就不存在由大于k 到dp[i]的可能性了
            if(i - W >= 0) Wsum -= dp[i-W];
        }
        return res;
    }
}