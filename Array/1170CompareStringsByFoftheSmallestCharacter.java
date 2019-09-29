// 1170. Compare Strings by Frequency of the Smallest Character
// Let's define a function f(s) over a non-empty string s, which calculates the frequency of the smallest character in s. For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.

// Now, given string arrays queries and words, return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), where W is a word in words.

 

// Example 1:

// Input: queries = ["cbd"], words = ["zaaaz"]
// Output: [1]
// Explanation: On the first query we have f("cbd") = 1, f("zaaaz") = 3 so f("cbd") < f("zaaaz").
// Example 2:

// Input: queries = ["bbb","cc"], words = ["a","aa","aaa","aaaa"]
// Output: [1,2]
// Explanation: On the first query only f("bbb") < f("aaaa"). On the second query both f("aaa") and f("aaaa") are both > f("cc").

class Solution {
    public int[] numSmallerByFrequency(String[] queries, String[] words) {
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
           int freq = 0;
           for(int j = 0; j < words.length; j++){
               if(f(queries[i]) < f(words[j])) freq++;
           }
           res[i] = freq;
       } 
       return res; 
    }
    public int f(String str){
        if(str == null || str.length() == 0) return 0;
        char min = str.charAt(0);
        int freq = 0;
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) < min)
                min = str.charAt(i);
        }
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == min)
                freq++;
        }
        return freq;
    }
}