// 166. Fraction to Recurring Decimal
// Given two integers representing the numerator and denominator of a fraction, return the fraction in string format.

// If the fractional part is repeating, enclose the repeating part in parentheses.

// Example 1:

// Input: numerator = 1, denominator = 2
// Output: "0.5"

class Solution {
    public String fractionToDecimal(int numerator1, int denominator1) {
        long numerator = numerator1;
        long denominator = denominator1;
        StringBuilder res = new StringBuilder();
        if(numerator*denominator < 0)
        { 
            res.append("-");
        }
        numerator = Math.abs(numerator);
        denominator = Math.abs(denominator);
        long node = numerator/denominator;
        long remain = numerator - denominator*node;
        res.append(node);
        if(remain == 0) return res.toString();
        res.append(".");
        HashMap<String,Integer> map = new HashMap<>();
        while(remain != 0)
        {
            node = (remain*10)/denominator;
            remain = remain*10 - node*denominator;
            if(!map.containsKey(remain + "+" + node)) 
                map.put(remain + "+" + node,res.length());
            else 
            {
                res.insert(map.get(remain + "+" + node),"(");
                res.append(")");
                break;
            }
            res.append(node);
        }
        
        return res.toString();
        
    }
}