// 77. Combinations

// Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

// Example:

// Input: n = 4, k = 2
// Output:
// [
//   [2,4],
//   [3,4],
//   [2,3],
//   [1,2],
//   [1,3],
//   [1,4],
// ]
// 解决方法：dfs 输入permutation然后之前用过的之后都不会再用
// 直觉：同解决方法 
// 要点，难点：1.dsf 遇到comb长度和k一样就返回
// 归类：算法一类 Permutation/backtracking
// 难点: bakctracking 到底要在什么地方new 并且输入dfs要输入i 不是index
// 复杂度： O(n)
// 数据结构：dfs

class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        int[] nums = new int[n];
        for(int i = 0; i < n; i++)
        {
            nums[i] = i+1;
        }
        
        dfs(0,nums,new ArrayList<>(),k,res);
        return res;
    }
    
    public void dfs(int index,int[] nums,List<Integer> comb,int k, List<List<Integer>> res)
    {
        if(comb.size() == k){
            res.add(comb);
            return;
        }
        
        for(int i = index; i < nums.length; i++)
        {
            List<Integer> combination = new ArrayList<>(comb);
            combination.add(nums[i]);
            dfs(i+1,nums,combination,k,res);
        }
    }
}