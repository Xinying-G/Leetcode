// 349. Intersection of Two Arrays
// Given two arrays, write a function to compute their intersection.

// Example 1:

// Input: nums1 = [1,2,2,1], nums2 = [2,2]
// Output: [2]

// 直觉：Hash
// 要点，难点：1. 必须要用两个hashset不然的话无法去除第二个set之中的duplicate
// 2. 要检查第一个set里面contain这个元素吗 而不是add成不成功，这样的话【】，【1，1】过不去
// 归类：Array HashSet
// 难点: 1.Hashset<>()
// 复杂度： O（n）
// 数据结构：Hash

class Solution {
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> rmdup = new HashSet<>();
        Set<Integer> fddup = new HashSet<>();
        for(int i: nums1) rmdup.add(i);
        for(int i: nums2) if(rmdup.contains(i)) fddup.add(i);
        int[] result = fddup.stream().mapToInt(Integer::intValue).toArray();
        
        return result;
    }

}