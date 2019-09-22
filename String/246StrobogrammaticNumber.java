// 246. Strobogrammatic Number
// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Write a function to determine if a number is strobogrammatic. The number is represented as a string.

// Example 1:

// Input:  "69"
// Output: true
// Example 2:

// Input:  "88"
// Output: true
// Example 3:

// Input:  "962"
// Output: false

class Solution {
    public boolean isStrobogrammatic(String num) {
        if(num == null || num.length() == 0) return false;
        if(num.charAt(0) == '0' && !num.equals("0")) return false;
        return isStobo(num);
    }
    
    public boolean isStobo(String num){
        System.out.println(num);
        String[] ones = new String[]{"0","1","8"};
        String[] twos = new String[]{"00","11","69","88","96"};
        if(num.length() == 1){
            for(String one: ones)
                if(one.equals(num)) return true;
            return false;
        }
        for(String two: twos){
            System.out.println(two);
           if(num.charAt(0) == two.charAt(0) && num.charAt(num.length()-1) == two.charAt(1)) 
    return num.length() > 2? isStobo(num.substring(1,num.length()-1)): true;
        }
        return false;   
    }
}