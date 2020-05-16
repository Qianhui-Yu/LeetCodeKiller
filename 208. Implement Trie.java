208. Implement Trie

class Trie {
    class Node {
        char c;
        Node[] arr;
        boolean isEnd;
        
        Node(char c) {
            this.c = c;
            this.arr = new Node[26];
        }
    }
    
    Node root;
    
    /** Initialize your data structure here. */
    public Trie() {
        this.root = new Node('\0');
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node cur = root;
        
        for (char c: word.toCharArray()) {
            if (cur.arr[c - 'a'] == null) {
                cur.arr[c - 'a'] = new Node(c);
            }
            cur = cur.arr[c - 'a'];
        }
        
        cur.isEnd = true;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Node cur = root;
        
        for (char c: word.toCharArray()) {
            if (cur.arr[c - 'a'] == null)
                return false;
            cur = cur.arr[c - 'a'];
        }
        
        return cur.isEnd;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Node cur = root;
        
        for (char c: prefix.toCharArray()) {
            if (cur.arr[c - 'a'] == null)
                return false;
            cur = cur.arr[c - 'a'];
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