// 6. ZigZag Conversion
// The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this: (you may want to display this pattern in a fixed font for better legibility)

// P   A   H   N
// A P L S I I G
// Y   I   R

// 直觉：找规律
// 要点，难点：1. 用了n行stringbuffer，stringbuffer里面可以append char，也可以append另一个StringBuffer
// 2. 对于每一行来说，👇add number直到到底，然后向上，从行数n-1走到行数1，然后再重头再走直到走完，最后把每一行都append起来
// 归类：String
// 难点: StringBuffer 可以用来储存chars
// 复杂度： O（n）
// 数据结构：Array，StringBuffer

class Solution {
    public String convert(String s, int numRows) {
        char[] chars = s.toCharArray();
        StringBuffer[] sb = new StringBuffer[numRows];
        for(int i = 0; i < numRows; i++)
            sb[i] = new StringBuffer();
        int i = 0, len = s.length(); 
        while(i < len)
        {
            for(int ind = 0; ind < numRows && i < len; ind++)
                sb[ind].append(chars[i++]);
            for(int ind = numRows -2; ind >= 1 && i < len; ind--)
                sb[ind].append(chars[i++]);
        }
        
        for(i = 1; i < numRows; i++)
        {
            sb[0].append(sb[i]);
        }
        return sb[0].toString();
    }
}