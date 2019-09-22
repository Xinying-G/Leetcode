// 241. Different Ways to Add Parentheses
// Given a string of numbers and operators, return all possible results from computing all the different possible ways to group numbers and operators. The valid operators are +, - and *.

// Example 1:

// Input: "2-1-1"
// Output: [0, 2]
// Explanation: 
// ((2-1)-1) = 0 
// (2-(1-1)) = 2



class Solution {
    public List<Integer> diffWaysToCompute(String input) {
        List<Integer> res = new LinkedList<>();
        for(int i = 0; i < input.length(); i++){
            if(input.charAt(i) == '+' || 
               input.charAt(i) == '-' || 
               input.charAt(i) == '*'){
                List<Integer> res1 = diffWaysToCompute(input.substring(0,i));
                List<Integer> res2 = diffWaysToCompute(input.substring(i+1));
                for(Integer j: res1){
                    for(Integer k: res2){
                        int c = 0;
                        switch(input.charAt(i)){
                            case '+': c = j+k;break;
                            case '-': c = j-k;break;
                            case '*': c = j*k;break;
                        }
                        res.add(c);
                    }
                }
            }
        }
        if(res.size() == 0)
            res.add(Integer.valueOf(input));
        return res;
    }
}