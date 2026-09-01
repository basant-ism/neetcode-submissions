class PrefixTree {
    TrieNode root;
    class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isEnd = false;
    }

    public PrefixTree() {
         root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            int ch = word.charAt(i)-'a';
            if(node.children[ch]==null) {
                node.children[ch] = new TrieNode();
            }
            node = node.children[ch];
        }
        node.isEnd=true;
    }

    public boolean search(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
             int ch = word.charAt(i)-'a';
            if(node.children[ch]==null) {
                return false;
            }
            node = node.children[ch];
        }
        return node.isEnd;
    }

    public boolean startsWith(String prefix) {
         TrieNode node = root;
        for(int i=0;i<prefix.length();i++) {
             int ch = prefix.charAt(i)-'a';
            if(node.children[ch]==null) {
                return false;
            }
            node = node.children[ch];
        }
        return true;
    }
}
