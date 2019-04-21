// 162. Find Peak Element
// A peak element is an element that is greater than its neighbors.

// Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.

// The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.

// You may imagine that nums[-1] = nums[n] = -∞.

// Example 1:

// Input: nums = [1,2,3,1]
// Output: 2
// Explanation: 3 is a peak element and your function should return the index number 2.

class Solution {
    public int findPeakElement(int[] nums) {
        return binarySearch(nums,0,nums.length-1);
    }
    
    public int binarySearch(int[] nums, int low, int high)
    {
        if(low == high) return low;
        int mid1 = (low+high)/2;
        int mid2 = mid1 +1;
        if(nums[mid1] > nums[mid2])
            return binarySearch(nums,low,mid1);
        else
            return binarySearch(nums,mid2,high);
    }
}