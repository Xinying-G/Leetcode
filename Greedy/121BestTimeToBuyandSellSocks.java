// 121. Best Time to Buy and Sell Stock
// Say you have an array for which the ith element is the price of a given stock on day i.

// If you were only permitted to complete at most one transaction (i.e., buy one and sell one share of the stock), design an algorithm to find the maximum profit.

// Note that you cannot sell a stock before you buy one.

// Example 1:

// Input: [7,1,5,3,6,4]
// Output: 5
// Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
//              Not 7-1 = 6, as selling price needs to be larger than buying price.
// Example 2:

// Input: [7,6,4,3,1]
// Output: 0
// Explanation: In this case, no transaction is done, i.e. max profit = 0.

// 直觉：dp or something, 只要找到本位置前面最小的，就能找到本位置的销售最大值，然后求每一位销售最大值的最大值
// 要点，难点：贪心算法，
// 归类：Greedy，DP？？
// 难点: empty的case
// 复杂度： O(n)
// 数据结构：Greedy

class Solution {
    public int maxProfit(int[] prices) {
        if(prices == null || prices.length == 0)
            return 0;
        int max = 0,min = prices[0];
        
        for(int i = 1; i < prices.length; i++)
        { 
            if(prices[i-1] < min) min = prices[i-1];
            max = Math.max(max,(prices[i] - min));
        }
        return max;
    }
}