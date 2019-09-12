// 448. Find All Numbers Disappeared in an Array
// Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.

// Find all the elements of [1, n] inclusive that do not appear in this array.

// Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.

// Example:

// Input:
// [4,3,2,7,8,2,3,1]

// Output:
// [5,6]

// 直觉：把遇到过的bucket的地方变成负数，最后没有变成负数的bucket就是没有数字指向的那个
// 要点，难点：
// 解决方法：类似于之前找出现两次的数字的那一个题
// 归类：Bucket
// 难点: 变成负数，最后返回的是array的index
// 复杂度： O(n)
// 数据结构：bucket

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for(int i = 0; i < nums.length; i++)
        {
            if(nums[Math.abs(nums[i]) -1] > 0)
                nums[Math.abs(nums[i]) -1] *= -1;
        }
        for(int i = 0; i < nums.length; i++)
            if(nums[i] > 0)
                res.add(i+1);
        return res;
    }
}

calves@winnco.com