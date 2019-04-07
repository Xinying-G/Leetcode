// 78. Subsets
// Given a set of distinct integers, nums, return all possible subsets (the power set).

// Note: The solution set must not contain duplicate subsets.

// Example:

// Input: nums = [1,2,3]
// Output:
// [
//   [3],
//   [1],
//   [2],
//   [1,2,3],
//   [1,3],
//   [2,3],
//   [1,2],
//   []
// ]

// 直觉：DFS，忘记了怎么做
// 要点，难点：1. 输入1，输入2，输入3，
// 1，2，3
// 1->1,2 1,3
// 1,2->1,2,3
// 2->2,3
// 3->return
// 归类：Math
// 难点: 1.permutation and combination and subset 统一用着一种方法，这是一道经典的
// DFS的题，需要反复做
// 复杂度： O（n）
// 数据结构：Array

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> res = new ArrayList<>();
        dfs(res,new ArrayList<Integer>(),0,nums);
        return res;
    }
    
    public void dfs(List<List<Integer>> res, List<Integer> tmp, 
               int start, int[] nums)
    {
        res.add(tmp);
        for(int i = start; i < nums.length; i++)
        {
            List<Integer> one = new ArrayList<>(tmp);
            one.add(nums[i]);
            dfs(res,one,i+1,nums);
        }
    }
}