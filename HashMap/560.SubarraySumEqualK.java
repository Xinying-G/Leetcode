// 560. Subarray Sum Equals K
// Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.

// Example 1:
// Input:nums = [1,1,1], k = 2
// Output: 2
// Note:
// The length of the array is in range [1, 20,000].
// The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].

// record sum of from 0 to nums.length, num(0,j) - num(0-i-1) is the sum of k. 
// From solution 1, we know the key to solve this problem is SUM[i, j]. So if we know SUM[0, i - 1] and SUM[0, j], then we can easily get SUM[i, j]. 
// To achieve this, we just need to go through the array, calculate the current sum and save number of all seen PreSum to a HashMap. 
// Time complexity O(n), Space complexity O(n).

// 直觉：sliding window,但是无法解决负数的问题
// 要点，难点：将array每一个位置的sum计算出来，sum[i,j] = SUM[0, j] - SUM[0, i - 1], 如果有重复的，hashmap要++，
// 如果有找到sum - k，证明有这个subarray，然后加上subarry hashmap的值
// 归类：Hashmap
// 难点: 
// 复杂度： O(n)
// 数据结构：HashMap


class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer,Integer> map = new HashMap<>();
        int sum = 0;
        int res = 0;
        map.put(0,1);
        for(int i = 0; i < nums.length; i++)
        {
            sum += nums[i];
            if(map.containsKey(sum - k)){
                res += map.get(sum - k);
            }
            map.put(sum, map.getOrDefault(sum, 0) + 1);
        }
        return res;
    }
}