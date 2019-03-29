// 58. Length of Last Word
// Easy
// Example:

// Input: "Hello World"
// Output: 5

class Solution {
    public int lengthOfLastWord(String s) {
        String[] word = s.split(" ");
        if(word.length == 0) return 0;
        return word[word.length-1].length();
    }
}