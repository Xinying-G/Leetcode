// 211. Add and Search Word - Data structure design
// Design a data structure that supports the following two operations:

// void addWord(word)
// bool search(word)
// search(word) can search a literal word or a regular expression string containing only letters a-z or .. A . means it can represent any one letter.

// Example:

// addWord("bad")
// addWord("dad")
// addWord("mad")
// search("pad") -> false
// search("bad") -> true
// search(".ad") -> true
// search("b..") -> true


class WordDictionary {
    class TrieNode{
        public boolean isWord;
        public TrieNode[] children = new TrieNode[26];
        public char val;
        public TrieNode(char chr){
            val = chr;
        }
        public TrieNode(){}
    }
    TrieNode root;
    /** Initialize your data structure here. */
    public WordDictionary() {
        root = new TrieNode();
    }
    
    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode node = root;
        for(char c : word.toCharArray())
        {
            if(node.children[c - 'a'] == null)
            {
                node.children[c - 'a'] = new TrieNode(c);
            }
            node = node.children[c - 'a'];
        }
        node.isWord = true;
    }
    
    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        TrieNode node = root;
        return match(0,root,word);
    }
    
    public boolean match(int k, TrieNode node,String word)
    {
        if(k == word.length()){
            if(node.isWord) return true;
            else 
            return false;} 
        if(word.charAt(k) != '.')
        {
            if(node.children[word.charAt(k) - 'a'] != null)
                return match(k+1,node.children[word.charAt(k) - 'a'],word);
            else return false;
        }
        else 
        {
            for(int i = 0; i < 26; i++)
            {
                
                if(node.children[i] != null && match(k+1,node.children[i],word))
                    return true;
            }
            return false;
        }
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */