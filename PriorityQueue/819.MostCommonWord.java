// 819. Most Common Word
// Given a paragraph and a list of banned words, return the most frequent word that is not in the list of banned words.  It is guaranteed there is at least one word that isn't banned, and that the answer is unique.

// Words in the list of banned words are given in lowercase, and free of punctuation.  Words in the paragraph are not case sensitive.  The answer is in lowercase.

// Example:

// Input: 
// paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
// banned = ["hit"]
// Output: "ball"
// Explanation: 
// "hit" occurs 3 times, but it is a banned word.
// "ball" occurs twice (and no other word does), so it is the most frequent non-banned word in the paragraph. 
// Note that words in the paragraph are not case sensitive,
// that punctuation is ignored (even if adjacent to words, such as "ball,"), 
// and that "hit" isn't the answer even though it occurs more because it is banned.

// 直觉：用hashmap和hashset
// 要点，难点：1. HashMap记录这个词出现的次数，hashset记录baned单词
// 解决方法：用哈是马屁、记录单词出现的次数，hashset记录baned的单词，如果没有被banned，
// 记录max和出现的频率和最大的这个单词是谁，直接put，进hashmap
// 归类：HashMap和HashSet
// 难点: HashMap和HashSet
// 复杂度：O(n) 
// 数据结构：String
class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Map<String,Integer> map = new HashMap<>();
        Set<String> banSet = new HashSet<>();
        int max = 0;
        String res = "";
        for(String b : banned)
        {
            banSet.add(b);
        }
        String[] strs = paragraph.replaceAll("[^a-zA-Z ]", " ").toLowerCase().split("\\s+");
        
        for(String str: strs)
        {
            if(!banSet.contains(str))
            {
                if(!map.containsKey(str))
                {
                  map.put(str,1); 
                  if(1 > max){
                        max = Math.max(1,max);
                        res = str;
                    }
                    
                }
                else
                {         
                    int value = map.get(str) + 1;
                    map.put(str,value);
                    if(value > max){
                        max = Math.max(value,max);
                        res = str;
                    }
                }
            }
        }
        return res;
    }
}