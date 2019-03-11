// Input:
// beginWord = "hit",
// endWord = "cog",
// wordList = ["hot","dot","dog","lot","log","cog"]

// Output: 5

// Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
// return its length 5.
// Example 2:

// Input:
// beginWord = "hit"
// endWord = "cog"
// wordList = ["hot","dot","dog","lot","log"]

// Output: 0

// Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
// 直觉：dfs
// 要点，难点：1.如何做bfs，设置两个stack，把begin的每一子叶子都push出来放进queue里面，直到放完为止
// 这道题用了HashSet作为queue， 把reahced里面neighbor的全部都找出来，然后放进新的序列里，同时为了防止neighbor找到之前的
// 我们可以在wordlist里面删除掉这个值
// 2. 做比较这道题运用了换掉每一个letter的字符来看是否相邻
// 3. HashSet contains add 
// 4. char[] = string.toCharArray()
// 5. wordList.remove()
// 归类：BFS
// 难点: 
// 复杂度： O(26*L*n) n = num of words in list L = length of each word
// 数据结构：BFS
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int distance = 1;
        Set<String> reached = new HashSet<String>();
        if(!wordList.contains(endWord)) return 0;
        reached.add(beginWord);
        wordList.add(endWord);
        while(!reached.contains(endWord))
        {
            Set<String> toAdd = new HashSet<String>();
            for(String each: reached)
            {
                for(int i = 0; i < each.length(); i++)
                {
                    char[] chars = each.toCharArray();
                    for(char a = 'a'; a <= 'z'; a++)
                    {
                        chars[i] = a;
                        String word = new String(chars);
                        if(wordList.contains(word))
                        {
                            toAdd.add(word);
                            wordList.remove(word);
                        }
                    }
                }
            }
            distance++;
            if(toAdd.size() == 0) return 0;
            reached = toAdd;
        }
        Iterator<String> i = reached.iterator(); 
        while (i.hasNext()) 
            System.out.println(i.next()); 
        return distance;
        
    }
}