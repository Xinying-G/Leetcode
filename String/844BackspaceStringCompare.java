// 844. Backspace String Compare
// Given two strings S and T, return if they are equal when both are typed into empty text editors. # means a backspace character.

// Example 1:

// Input: S = "ab#c", T = "ad#c"
// Output: true
// Explanation: Both S and T become "ac".
// Example 2:

// Input: S = "ab##", T = "c#d#"
// Output: true
// Explanation: Both S and T become "".
// Example 3:

// Input: S = "a##c", T = "#a#c"
// Output: true
// Explanation: Both S and T become "c".
// Example 4:

// Input: S = "a#c", T = "b"
// Output: false
// Explanation: S becomes "c" while T becomes "b".


class Solution {
    public boolean backspaceCompare(String S, String T) {
        StringBuilder sb1 = new StringBuilder();
        StringBuilder sb2 = new StringBuilder();
        for(char ch: S.toCharArray()){
            if(ch == '#'){
                if(sb1.length() > 0)
                    sb1.deleteCharAt(sb1.length()-1); 
            }
            else{
                sb1.append(ch);
            }
        }
        
        for(char ch: T.toCharArray()){
            if(ch == '#'){
                if(sb2.length() > 0)
                    sb2.deleteCharAt(sb2.length()-1); 
            }
            else{
                sb2.append(ch);
            }
        }
        return sb1.toString().equals(sb2.toString());
        
    }
}