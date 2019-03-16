// 49. Group Anagrams
// Given an array of strings, group anagrams together.

// Example:

// Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
// Output:
// [
//   ["ate","eat","tea"],
//   ["nat","tan"],
//   ["bat"]
// ]
// Note:

// All inputs will be in lowercase.
// The order of your output does not matter.

// 直觉：hashmap
// 要点，难点：1. Map<String, List<String>> map = new HashMap<>();
// 2. map.contains();
// 3. new ArrayList<List<String>>(map.values())
// 4. map.put(key,value)
// 5. key是sorted string，value是List<String>， hashmap可以直接new value
// 归类：hashmap
// 难点: map的使用方式
// 复杂度： O(n)
// 数据结构：Greedy

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> res = new ArrayList<List<String>>();
        HashMap<String, Integer> map = new HashMap<>(); 
        int counter = 0;
        for(int i = 0; i < strs.length; i++)
        {
            char[] chars = strs[i].toCharArray();
            Arrays.sort(chars);
            String word = new String(chars);
            
            if(map.containsKey(word)) 
            {
                Integer a = map.get(word);
                res.get(a).add(strs[i]);
            }
            else 
            {
                map.put(word,counter++);
                List<String> level = new ArrayList<String>();
                level.add(strs[i]);
                res.add(level);
            }            
        }
        
        return res;
    }
}