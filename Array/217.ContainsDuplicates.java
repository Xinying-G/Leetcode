// 217. Contains Duplicate
// Given an array of integers, find if the array contains any duplicates.

// Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.

// Example 1:

// Input: [1,2,3,1]
// Output: true

// 直觉：Hash
// 要点，难点：1. Hash
// 归类：Math
// 难点: 1.Hashset<>()
// 复杂度： O（n）
// 数据结构：Hash

class Solution {
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hash = new HashSet<>();
        for(int i: nums) if(!hash.add(i)) return true;
        return false;
    }
}