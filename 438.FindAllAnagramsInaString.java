// 438. Find All Anagrams in a String
// Given a string s and a non-empty string p, find all the start indices of p's anagrams in s.

// Strings consists of lowercase English letters only and the length of both strings s and p will not be larger than 20,100.

// The order of output does not matter.

// Example 1:

// Input:
// s: "cbaebabacd" p: "abc"

// Output:
// [0, 6]

// Explanation:
// The substring with start index = 0 is "cba", which is an anagram of "abc".
// The substring with start index = 6 is "bac", which is an anagram of "abc".
// Example 2:

// Input:
// s: "abab" p: "ab"

// Output:
// [0, 1, 2]

// Explanation:
// The substring with start index = 0 is "ab", which is an anagram of "ab".
// The substring with start index = 1 is "ba", which is an anagram of "ab".
// The substring with start index = 2 is "ab", which is an anagram of "ab".

// 直觉：把它都变成分钟，然后sort一下，然后两两相比
// 要点，难点：如何比两个时间，第一个时间往后走，跨越一天，到达第二个时间
// 第一个时间，不往后走也能到达第二个时间
// 第二个时间往后走，跨越一天到达第一个时间
// 第二个时间往后走，步跨越一天也能到达第一个时间
// 解决方法：把它都变成分钟，然后sort一下，然后两两相比，最后要比较一下头尾
// 归类：Array
// 难点: 换算成时间两两相比
// 复杂度：O(nlogn) 
// 数据结构：Array

class Solution {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if(s == null || s.length() == 0 || p == null || p.length() == 0)
            return res;
        int[] cache = new int[256];
        for(char ch : p.toCharArray()){
            cache[ch]++;
        }
        int left = 0, right = 0, count = p.length(); 
        while(right < s.length()){
            if(cache[s.charAt(right++)]-- >= 1) count--;
            if(count == 0) res.add(left);
            if(right - left == p.length() && cache[s.charAt(left++)]++ >= 0)count++;
        }
        return res;
    }
}