class Solution {
    // class TrieNode {
    //     TrieNode[] links = new TrieNode[26];

    // }
    // TrieNode build(int row,int col,char[][] board,boolean[][] vis) {
    //     vis[row][col]=true;
    //     int rows=board.length;
    //     int cols = board[0].length;
    //     int[] rr = {-1,0,1,0};
    //     int[] cc = {0,1,0,-1};
    //     TreeNode root = new TreeNode();
    //     for(int i=0;i<4;i++){
    //         int r = row + rr[i];
    //         int c = col + cc[i];
    //         if(r>=0 && r<rows && c>=0 && c<cols && vis[r][c]==false) {
    //             root.
    //         }
    //     }
    // }
    // TrieNode[][] buildUtil(char[][] board){
    //     int rows=board.length;
    //     int cols = board[0].length;
    //     TrieNode[][] trie = new TrieNode[rows][cols];
    //     for(int row=0;row<rows;row++){
    //         for(int col=0;col<cols;col++){
    //             boolean[][] vis = new boolean[rows][cols];
    //             trie[row][col]=build(row,col,board,vis);
    //         }
    //     }

    // }
    TrieNode root = new TrieNode();
    List<String> ans = new ArrayList<>();

    class TrieNode {
        TrieNode[] links = new TrieNode[26];
        String word;
    }

    void insert(String word) {
        TrieNode node = root;
        for(int i=0;i<word.length();i++) {
            char ch = word.charAt(i);
            if(node.links[ch-'a']==null) node.links[ch-'a']= new TrieNode();
            node = node.links[ch-'a'];
        }
        node.word = word;
    }

    void dfs(int row, int col, char[][] board, TrieNode node) {
        char ch = board[row][col];
        if(ch=='#' || node.links[ch-'a'] == null) return;

        if(node.links[ch-'a'].word != null)  {
            ans.add(node.links[ch-'a'].word);
            node.links[ch-'a'].word = null;
        }

        board[row][col]='#';
        int rows = board.length;
        int cols = board[0].length;
        int[] dr = {-1,0,1,0};
        int[] dc = {0,1,0,-1};
        for(int i=0;i<4;i++){
            int r = row + dr[i];
            int c = col + dc[i];
            if(r>=0 && r<rows && c>=0 && c<cols) {
                dfs(r,c,board,node.links[ch-'a']);
            }
        }

        board[row][col]=ch;
    }

    public List<String> findWords(char[][] board, String[] words) {
        for(int i=0;i<words.length;i++){
            insert(words[i]);
        }
        for(int row=0;row<board.length;row++){
            for(int col=0;col<board[0].length;col++){
                dfs(row,col,board,root);
            }
        }
        return ans;
    }
}
