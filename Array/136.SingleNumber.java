// 136. Single Number
// Given a non-empty array of integers, every element appears twice except for one. Find that single one.

// Note:

// Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

// Example 1:

// Input: [2,2,1]
// Output: 1

// 直觉：Hash
// 要点，难点：1. Hash
// 归类：Math
// 难点: 1.Hashset<>()
// 复杂度： O（n）
// 数据结构：Hash

class Solution {
    public int singleNumber(int[] nums) {
        Set<Integer> res = new HashSet<>();
        for(int i: nums) if(!res.add(i)) res.remove(i);
        Integer[] c =  res.toArray(new Integer[1]);
        return c[0];
        
    }
}