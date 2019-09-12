// 322. Coin Change
// You are given coins of different denominations and a total amount of money amount. Write a function to compute the fewest number of coins that you need to make up that amount. If that amount of money cannot be made up by any combination of the coins, return -1.

// Example 1:

// Input: coins = [1, 2, 5], amount = 11
// Output: 3 
// Explanation: 11 = 5 + 5 + 1
// Example 2:

// Input: coins = [2], amount = 3
// Output: -1
// Note:
// You may assume that you have an infinite number of each kind of coin.



class Solution {
    public int coinChange(int[] coins, int amount) {
        if(amount == 0) return 0;
        Arrays.sort(coins);
        int count =  helper(coins,amount);
        return count == Integer.MIN_VALUE? -1: count;
    }
    
    public int helper(int[] coins, int amount){
        int min = Integer.MAX_VALUE;
        // if(amount < coins[0]) return min;
        for(int i = coins.length-1; i>=0; i--)
        {
            if(amount > coins[i]){
                int count = helper(coins,amount-coins[i]); 
                if(count > -1)
                    min = Math.min(count, min);
            }
            else if(amount == coins[i]) min = 0;
            // if(min != Integer.MAX_VALUE)
            //     break;
        }
        return min+1;
    }
    
    
    public int coinChange(int[] coins, int amount) {
        if(amount < 1) return 0;
        int[] dp = new int[amount+1];
        int sum = 0;
        while(++sum <= amount)
        {
            int min = -1;
            for(int coin : coins)
            {
                if(sum >= coin && dp[sum - coin] != -1)
                {
                    if(dp[sum] == 0)
                        dp[sum] = dp[sum - coin] +1;
                    else dp[sum] = Math.min(dp[sum -coin] +1, dp[sum]);
                }
            }
            if(dp[sum] == 0) dp[sum] = -1;
        }
        return dp[amount];
   
    }
    
}