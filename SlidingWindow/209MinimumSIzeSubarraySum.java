// 209. Minimum Size Subarray Sum
// Medium

// 1112

// 70

// Favorite

// Share
// Given an array of n positive integers and a positive integer s, find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.

// Example: 

// Input: s = 7, nums = [2,3,1,2,4,3]
// Output: 2
// Explanation: the subarray [4,3] has the minimal length under the problem constraint.
// Follow up:
// If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n). 
    


public int minSubArrayLen(int s, int[] nums) {
    if(nums == null || nums.length == 0) return 0;
    int i = 0, j = 0;
    int sum = nums[0];
    int min = Integer.MAX_VALUE;
    while(i < nums.length && j < nums.length)
    {
        if(sum >= s) {
            min = Math.min(min,j-i+1);
            i++;
            if(i < j) sum -= nums[i-1];
            else{
                if(i >= nums.length) return min;
                j = i; 
                sum = nums[i];
            }
        }
        if(sum < s) 
        {
            j++; 
            if(j < nums.length) sum += nums[j];
            else break;
        }
    }
    
    return min == Integer.MAX_VALUE? 0: min;
}