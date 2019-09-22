// 280. Wiggle Sort
// Given an unsorted array nums, reorder it in-place such that nums[0] <= nums[1] >= nums[2] <= nums[3]....

// Example:

// Input: nums = [3,5,2,1,6,4]
// Output: One possible answer is [3,5,1,6,2,4]

class Solution {
    public void wiggleSort(int[] nums) {
        if(nums == null || nums.length == 0) return;
        boolean isBig = false;
        for(int i = 0; i < nums.length-1; i++){
            if((isBig && nums[i] < nums[i+1]) || (!isBig && nums[i] > nums[i+1]))
                swap(i,i+1,nums);
            isBig = !isBig;
        }
    }
    public void swap(int i, int j, int[] nums){
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}