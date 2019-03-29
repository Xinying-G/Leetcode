// 1. Two Sum
// Given an array of integers, return indices of the two numbers such that they add up to a specific target.

// You may assume that each input would have exactly one solution, and you may not use the same element twice.

// Example:

// Given nums = [2, 7, 11, 15], target = 9,

// Because nums[0] + nums[1] = 2 + 7 = 9,
// return [0, 1].

// 直觉：HashMap
// 要点，难点：1. HashMap 怎么写 HashMap<Integer, Integer> map =  new HashMap<>();
// 2. map.put(a,b)
// 3. map.containsKey()
// 归类：Array
// 难点: 1.HashMap<>()
// 复杂度： O（n）
// 数据结构：HashMap

class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for(int i = 0; i < nums.length; i++)
        {
            if(map.containsKey(target - nums[i]))
            {
                res[1] = map.get(target - nums[i]);
                res[0] = i;
            }
            map.put(nums[i],i);
        }
        
        return res;
    }
}