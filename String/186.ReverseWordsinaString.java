// 186. Reverse Words in a String II
// Given an input string , reverse the string word by word. 

// Example:

// Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
// Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

// 直觉：不会
// 要点，难点：1. 先全部都reverse一遍 然后再逐个reverse单词
// 解决方法： 先全部都reverse一遍再逐个reverse单词
// 归类：String
// 难点: String
// 复杂度：O(n) 
// 数据结构：String

class Solution {
    public void reverseWords(char[] str) {
        if(str == null || str.length == 0) return;
        reverse(0,str.length-1, str);
        int i = 0, j = 0;
        while(j <= str.length)
        {
            if(j == str.length || str[j] == ' ')
            {
                reverse(i,j-1,str);
                i = j+1;
                j = i;
            }
            else j++;
        }
    }
    public void reverse(int start, int end, char[] str)
    {
        int i = start, j = end;
        while(i < j)
        {
            char temp = str[i];
            str[i] = str[j];
            str[j] = temp;
            i++; j--;
        }
    }
}