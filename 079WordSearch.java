class Solution {
    public boolean exist(char[][] board, String word) {
        if(word.length() == 0 || board.length == 0 || board[0].length == 0) return false;
        int m = board.length,n = board[0].length;
        boolean flag = false;
        boolean[][] visited = new boolean[m][n];
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(board[i][j] == word.charAt(0)) {
                    visited[i][j] = true;
                    flag = helper(board,word,1,visited,i,j);
                    if(flag) return true;
                }
            }
        }
        return false;
    }
    
    boolean helper(char[][] board,String word,int index,boolean[][] visited,int r,int c) {
        int m = board.length,n = board[0].length;
        if(index == word.length()) return true;
        int nextR,nextC;
        boolean flag = false;
        nextR = r;
        nextC = (c+1)%n;
        if(!visited[nextR][nextC] && word.charAt(index) == board[nextR][nextC]) {
            visited[nextR][nextC] = true;
            flag = helper(board,word,index+1,visited,nextR,nextC);
            if(flag) return true;
            else visited[nextR][nextC] = false;
        }
        nextR = r;
        nextC = (c-1+n)%n;
        if(!visited[nextR][nextC] && word.charAt(index) == board[nextR][nextC]) {
            visited[nextR][nextC] = true;
            flag = helper(board,word,index+1,visited,nextR,nextC);
            if(flag) return true;
            else visited[nextR][nextC] = false;
        }
        nextR = (r+1)%m;
        nextC = c;
        if(!visited[nextR][nextC] && word.charAt(index) == board[nextR][nextC]) {
            visited[nextR][nextC] = true;
            flag = helper(board,word,index+1,visited,nextR,nextC);
            if(flag) return true;
            else visited[nextR][nextC] = false;
        }
        nextR = (r-1+m)%m;
        nextC = c;
        if(!visited[nextR][nextC] && word.charAt(index) == board[nextR][nextC]) {
            visited[nextR][nextC] = true;
            flag = helper(board,word,index+1,visited,nextR,nextC);
            if(flag) return true;
            else visited[nextR][nextC] = false;
        }
        return false;
    }
}
