// 93. Restore IP Addresses
// Given a string containing only digits, restore it by returning all possible valid IP address combinations.

// Example:

// Input: "25525511135"
// Output: ["255.255.11.135", "255.255.111.35"]

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        dfs(4,0,s,res,"");
        return res;
    }
    
    public void dfs(int n, int start, String s, List<String> res, String builder)
    {
        if(s.length() - start > 3*n) return;
        if(n != 0 && start == s.length())  return;
        if(start == s.length()) {
            builder = builder.substring(0,builder.length()-1); 
            res.add(builder); 
            return;
        }
        for(int i = start; i < start+4; i++)
        {
            if(i > s.length()-1) return;
            String news = new String(builder);
            // System.out.println(i+1);
            if(Integer.parseInt(s.substring(start,i+1)) <= 255 && 
               !(s.charAt(start) == '0' && start != i))
            {
                news += s.substring(start,i+1) + ".";
                dfs(n-1,i+1,s,res,news);
            }
            else break;
        }
    }
}