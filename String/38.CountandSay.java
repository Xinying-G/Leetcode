// 38. Count and Say
// The count-and-say sequence is the sequence of integers with the first five terms as following:

// 1.     1
// 2.     11
// 3.     21
// 4.     1211
// 5.     111221
// 1 is read off as "one 1" or 11.
// 11 is read off as "two 1s" or 21.
// 21 is read off as "one 2, then one 1" or 1211.

// Given an integer n where 1 ≤ n ≤ 30, generate the nth term of the count-and-say sequence.
// Note: Each term of the sequence of integers will be represented as a string.

// 直觉：数数字，如果数字有变化就重新数，最后再加上最后一个counter，要小心 
// 要点，难点：1.，因为j是从1开始所以要单独考虑n=2的问题， 
// 归类：Array
// 难点: Array
// 复杂度： O(n)
// 数据结构：for loop
class Solution {
    public String countAndSay(int n) {
        String a = "1";
        for(int i = 0; i < n-1; i++)
        {
            int counter = 1;
            StringBuilder sb = new StringBuilder();
            if(a.length() == 1) 
            {
                a = "11";
                continue;
            }
            for(int j = 1; j < a.length(); j++)
            {
                if(a.charAt(j-1) == a.charAt(j)) counter++;
                else{
                    sb.append(counter);
                    sb.append(a.charAt(j-1));
                    counter = 1;
                }
            }
           sb.append(counter);
           sb.append(a.charAt(a.length()-1));
           counter = 1;
           a = sb.toString();
           System.out.print(a);
            System.out.print("  ");
        }
        return a;
    }
}