class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int m = board.length,n = board[0].length;
        boolean[][] flags = new boolean[m+2][n+2];
        for(int i = 0;i < n+2;i++) {
            flags[0][i] = true;
            flags[m+1][i] = true;
        }
        for(int i = 1;i < m+1;i++) {
            flags[i][0] = true;
            flags[i][n+1] = true;
        }
        for(int i = 1;i < m+1;i++) {
            for(int j = 1;j < n+1;j++) {
                if(board[i-1][j-1] == 'O' && (flags[i-1][j]||flags[i+1][j]||flags[i][j-1])||flags[i][j+1]) {
                    flags[i][j] = true;
                }
                if(board[i-1][j-1] == 'O' && !flags[i][j]) board[i-1][j-1] = 'X';
            }
        }
        return;
    }
}
