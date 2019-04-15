// 151. Reverse Words in a String
// Given an input string, reverse the string word by word.

 
class Solution {
    public String reverseWords(String s) {
        if(s.length() == 0) return s;
        int i = 0, j = 0;
        String res = "";
        while(i < s.length())
        {
            if(!(s.charAt(i) == ' '))
            {
                j = i;
                while(j < s.length() && !(s.charAt(j) == ' '))
                {
                    j++;
                }
                j--;
                res = s.substring(i,j+1) + " " + res;
                i = j+1;
            }
            i++;
        }
        return res.length() == 0? res: res.substring(0,res.length()-1);
    }
}