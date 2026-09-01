class WordDictionary {
    TrieNode root;
    class TrieNode {
        TrieNode[] children;
        boolean isEnd;
        TrieNode() {
            this.children = new TrieNode[26];
            this.isEnd = false;
        }
    }

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++){
            int ch = word.charAt(i) - 'a';
            if(node.children[ch]==null) {
                node.children[ch]=new TrieNode();
            }
            node = node.children[ch];
        }
        node.isEnd = true;
    }

    public boolean search(String word) {
       return search(word,0,root);
    }
    private boolean search(String word, int start, TrieNode node) {
        //System.out.println(start+ ":");
        for(int i=start;i<word.length();i++) {
            char ch = word.charAt(i);
            if(ch == '.') {
                //any char is fine
                for(int j=0;j<26;j++) {
                    if(node.children[j]!= null) {
                        if(search(word,i+1,node.children[j])) {
                            return true;
                        }
                    }
                }
                return false;
            } else {
                //normal char
                int index = ch-'a';
                    if(node.children[index]==null) {
                        return false;
                    }
                    node = node.children[index];
            }
        }
        return node.isEnd;
    }
}
