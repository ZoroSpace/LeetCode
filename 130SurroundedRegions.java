class Solution {
    public void solve(char[][] board) {
        if(board.length == 0 || board[0].length == 0) return;
        int m = board.length,n = board[0].length;
        LinkedList<Integer> rIndex = new LinkedList<>();
        LinkedList<Integer> cIndex = new LinkedList<>();
        
        boolean[][] visited = new boolean[m][n];
        int r,c,size;
        for(int i = 0;i < n;i++) {
            if(board[0][i] == 'O') {
                rIndex.offer(0);
                cIndex.offer(i);
                visited[0][i] = true;
            }
            if(board[m-1][i] == 'O') {
                rIndex.offer(m-1);
                cIndex.offer(i);
                visited[m-1][i] = true;
            }
        }
        for(int i = 1;i < m-1;i++) {
            if(board[i][0] == 'O') {
                rIndex.offer(i);
                cIndex.offer(0);
                visited[i][0] = true;
            }
            if(board[i][n-1] == 'O') {
                rIndex.offer(i);
                cIndex.offer(n-1);
                visited[i][n-1] = true;
            }
        }
        while(rIndex.size() != 0) {
            size = rIndex.size();
            for(int i = 0;i < size;i++) {
                r = rIndex.poll();
                c = cIndex.poll();
                if(r+1 < m && board[r+1][c] == 'O' && !visited[r+1][c]) {
                    visited[r+1][c] = true;
                    rIndex.offer(r+1);
                    cIndex.offer(c);
                }
                if(r>0 && board[r-1][c] == 'O' && !visited[r-1][c]) {
                    visited[r-1][c] = true;
                    rIndex.offer(r-1);
                    cIndex.offer(c);
                }
                if(c+1 < n && board[r][c+1] == 'O' && !visited[r][c+1]) {
                    visited[r][c+1] = true;
                    rIndex.offer(r);
                    cIndex.offer(c+1);
                }
                if(c>0 && board[r][c-1] == 'O' && !visited[r][c-1]) {
                    visited[r][c-1] = true;
                    rIndex.offer(r);
                    cIndex.offer(c-1);
                }
            }
        }
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(board[i][j] == 'O' && !visited[i][j]) board[i][j] = 'X';
            }
        }
        return;
    }
}
