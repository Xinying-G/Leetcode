// 247. Strobogrammatic Number II
// A strobogrammatic number is a number that looks the same when rotated 180 degrees (looked at upside down).

// Find all strobogrammatic numbers that are of length = n.

// Example:

// Input:  n = 2
// Output: ["11","69","88","96"]

class Solution {
    public List<String> findStrobogrammatic(int n) {
        String[] ones = new String[]{"0","1","8"};
        String[] twos = new String[]{"00","11","88","69","96"};
        List<String> with0 = helper(n,ones,twos);
        List<String> res = new ArrayList<>();
        for(String str: with0){
            if(str.charAt(0) != '0' || str.equals("0"))
                res.add(str);
        }
        return res;
    }
    
    public List<String> helper(int n, String[] ones, String[] twos) {
        List<String> res = new ArrayList<>();
        if(n == 1){
            for(String str: ones)
                res.add(str);
        }
        else if(n == 2){
            for(String str: twos)
                res.add(str);
        }
        else{
            List<String> previous = helper(n-2,ones,twos);
            for(String str: twos){
                for(String pre: previous){
                    StringBuilder sb = new StringBuilder();
                    sb.append(str.charAt(0));
                    sb.append(pre);
                    sb.append(str.charAt(1));
                    res.add(sb.toString());
                }
            }
        }
        return res;
    }
}