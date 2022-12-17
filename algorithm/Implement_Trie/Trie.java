public class Trie {

    private Trie[] nextLink;
    private boolean endFlag;

    /** Initialize your data structure here. */
    public Trie() {
        this.nextLink = new Trie[26];
        this.endFlag = false;
    }
    
    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie rootNode = this;
        for(int i=0;i<word.length();i++) {
            char tmpChar = word.charAt(i);
            if(rootNode.nextLink[tmpChar - 'a'] == null) {
                rootNode.nextLink[tmpChar - 'a'] = new Trie();
            }
            rootNode = rootNode.nextLink[tmpChar - 'a'];
        }
        rootNode.endFlag = true;
    }

    private Trie searchPrefix(String word) {
        Trie rootNode = this;
        for(int i=0;i<word.length();i++) {
            int tmpIndex = word.charAt(i) - 'a';
            if(rootNode.nextLink[tmpIndex] == null) {
                return null;
            }

            rootNode = rootNode.nextLink[tmpIndex];
        }

        return rootNode;
    }
    
    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie node = this.searchPrefix(word);
        return node != null && node.endFlag;
    }
    
    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        Trie node = this.searchPrefix(word);
        return node != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */
