// 3. Longest Substring Without Repeating Characters
// Given a string, find the length of the longest substring without repeating characters.

// Example 1:

// Input: "abcabcbb"
// Output: 3 
// Explanation: The answer is "abc", with the length of 3. 

// 直觉：不会
// 要点，难点：1. Sliding Window， 一边在增长，但是另一边只可以往前不可以往后，从而找到最大值
// 2.用HashMap储存index of element appeared before and start counting elements
// from one element after that. The sliding window can't go back because of situation like this a[bcba]c 
// 解决方法： 用一个HashMap record all the elements' index appeared before. if the element appeared before,
// The left side of window would go to the position next to it and The window was not allowed to go backwards.
// 归类：Sliding window
// 难点: Sliding Window
// 复杂度：O(n) 
// 数据结构：Sliding Window

class Solution {
    public int lengthOfLongestSubstring(String s) {
        if(s.length() == 0) return 0;
        HashMap<Character,Integer> map = new HashMap<>();
        int max = 0; int j = 0;
        for(int i = 0; i < s.length(); i++)
        {
            if(map.containsKey(s.charAt(i)))
            {
                j = Math.max(map.get(s.charAt(i))+1,j);
            }
            map.put(s.charAt(i),i);
            max = Math.max(max,i-j+1);
        }
        return max;
    }
}

