// 208. Implement Trie (Prefix Tree)
// Implement a trie with insert, search, and startsWith methods.

// Example:

// Trie trie = new Trie();

// trie.insert("apple");
// trie.search("apple");   // returns true
// trie.search("app");     // returns false
// trie.startsWith("app"); // returns true
// trie.insert("app");   
// trie.search("app");     // returns true


class TrieNode{
    public char val;
    public TrieNode[] children = new TrieNode[26];
    public boolean isWord;
    public TrieNode() {};
}


class Trie {
    private TrieNode root;
    /** Initialize your data structure here. */
    public Trie() {
        root = new TrieNode();
        
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        TrieNode wc = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(wc.children[word.charAt(i) - 'a'] == null)
            {
                TrieNode child = new TrieNode();
                child.val = word.charAt(i);
                wc.children[word.charAt(i) - 'a'] = child;
            }
            wc = wc.children[word.charAt(i) - 'a'];
        }
        wc.isWord = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode wc = root;
        for(int i = 0; i < word.length(); i++)
        {
            if(wc.children[word.charAt(i) - 'a'] == null)
                return false;
            wc = wc.children[word.charAt(i) - 'a'];
        }
        
        return wc.isWord;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode wc = root;
        for(int i = 0; i < prefix.length(); i++)
        {
            if(wc.children[prefix.charAt(i) - 'a'] == null)
                return false;
            wc = wc.children[prefix.charAt(i) - 'a'];
        }
        
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */