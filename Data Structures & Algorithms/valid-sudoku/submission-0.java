class Solution {
    boolean isRowValid(int row, char[][] board) {
        int[] freq = new int[9];
        for(int col=0;col<9;col++){
            char ch = board[row][col];
            if(ch=='.') continue;
            freq[ch-'1']++;
            if(freq[ch-'1']>1) return false;
        }
        return true;
    }
    boolean isColValid(int col, char[][] board) {
        int[] freq = new int[9];
        for(int row=0;row<9;row++){
            char ch = board[row][col];
            if(ch=='.') continue;
            freq[ch-'1']++;
            if(freq[ch-'1']>1) return false;
        }
        return true;
    }
    boolean isBoxValid(int x, int y, char[][] board) {
        int[] freq = new int[9];
        for(int i=0;i<3;i++) {
            for(int j=0;j<3;j++){
                int row = i+x;
                int col = j+y;
                char ch = board[row][col];
                if(ch=='.') continue;
                freq[ch-'1']++;
                if(freq[ch-'1']>1) return false;
            }
        }
        return true;
    }
    public boolean isValidSudoku(char[][] board) {
        //row valid
        for(int row=0;row<9;row++){
            if(!isRowValid(row,board)) return false;
        }
        //col valid
        for(int col=0;col<9;col++){
            if(!isColValid(col,board)) return false;
        }

        //box valid
        for(int x=0;x<9;x+=3){ 
            for(int y=0;y<9;y+=3) {
                if(!isBoxValid(x,y,board)) return false;
            }
        }
        return true;
    }
}
