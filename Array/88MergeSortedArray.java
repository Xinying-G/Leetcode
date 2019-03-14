// 88. Merge Sorted Array
// Given two sorted integer arrays nums1 and nums2, merge nums2 into nums1 as one sorted array.

// Note:

// The number of elements initialized in nums1 and nums2 are m and n respectively.
// You may assume that nums1 has enough space (size that is greater or equal to m + n) to hold additional elements from nums2.
// Example:

// Input:
// nums1 = [1,2,3,0,0,0], m = 3
// nums2 = [2,5,6],       n = 3

// Output: [1,2,2,3,5,6]

// 直觉：从最大的开始，把最大的放在最后的空位上，直到放完一个数列为止，因为放的位置永远会大于等于nums1的位置所以不用担心会超出去
// 要点，难点：1. 后向merge sort
// 归类：MergeSort
// 难点: MergeSort
// 复杂度： O(n)
// 数据结构：Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if(n == 0) 
            return;
        if(m == 0) 
        {
          for(int i = 0; i < n; i++)
          {
              nums1[i] = nums2[i];
          }
          return;
        }

        int i = m-1, j = n-1, k = m+n-1;
        while(i >= 0 && j >= 0)
        {
            if(nums1[i] > nums2[j])
            {
                nums1[k] = nums1[i];
                i--;
            }
            else 
            {
                nums1[k] = nums2[j];
                j--;
            }
            k--;
        }
        while(i >= 0)
        {
            nums1[k] = nums1[i];
            i--;
            k--;
        }
        while(j >= 0)
        {
            nums1[k] = nums2[j];
            j--;
            k--;
        }
    }
}