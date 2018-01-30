class Solution {
    public void solveSudoku(char[][] board) {
        boolean[][] filled = new boolean[9][9];
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                if(board[i][j] != '.') filled[i][j] = true;
            }
        }
        if(helper(board,filled)) return;
    }
    
    boolean helper(char[][] board,boolean[][] filled) {
        if(isFull(filled)) return true;
        boolean flag = false;
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                if(filled[i][j]) continue;
                for(char k = '1';k <= '9';k++) {
                    if(isValid(board,filled,i,j,k)) {
                        board[i][j] = k;
                        filled[i][j] = true;
                        flag = helper(board,filled);
                        if(flag) return true;
                        else {
                            board[i][j] = '.';
                            filled[i][j] = false;
                        }
                    }
                }
            }
        }
        return false;
    }
    
    boolean isValid(char[][] board,boolean[][] filled,int r,int c,char num) {
        int newR = r/3*3,newC = c/3*3;
        for(int i = 0;i < 9;i++) {
            if((filled[r][i] && board[r][i] == num) || (filled[i][c] && board[i][c] == num) || (filled[newR+i/3][newC+i%3] && board[newR+i/3][newC+i%3] == num)) return false;
        }
        return true;
    }
    
    boolean isFull(boolean[][] filled) {
        for(int i = 0;i < 9;i++) {
            for(int j = 0;j < 9;j++) {
                if(!filled[i][j]) return false;
            }
        }
        return true;
    }
}
