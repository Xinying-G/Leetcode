// 350. Intersection of Two Arrays II
// Given two arrays, write a function to compute their intersection.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2,2]
// Merge sort
// 直觉：merge sort 
// 要点，难点：Merge sort 选取i, j,选择小的放
// 归类：Sort
// 难点: 
// 复杂度： O(n+m)
// 数据结构：Merge Sort

class Solution {
    public int[] intersect(int[] nums1, int[] nums2) {
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i = 0,j = 0,k=0;
        while(i < nums1.length && j <  nums2.length)
        {
            if(nums1[i] == nums2[j]){nums1[k] = nums1[i];k++;i++;j++;}
            else if(nums1[i] < nums2[j]){i++;}
            else if(nums1[i] > nums2[j]){j++;}
        }
        int [] nums = new int[k];
        for(i = 0; i < k; i++) nums[i] = nums1[i];
        return nums;
    }
}