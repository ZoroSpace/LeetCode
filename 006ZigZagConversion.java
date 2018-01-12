class Solution {
    public String convert(String s, int n) {
        if(n <= 1 || n >= s.length()) return s;
        int width = (s.length()/(2*n-2)+1)*(n-1);
        char[][] store = new char[n][width];
        //按列填入
        int r = 0,c = 0;
        for(int i = 0;i < s.length();i++) {
            store[r][c] = s.charAt(i);
            if(c%(n-1) == 0 && r < n - 1) r++;
            else {
                r--;
                c++;
            }
        }
        //按行取出
        StringBuilder sb = new StringBuilder("");
        for(int i = 0;i < n;i++) {
            for(int j = 0;j < width;j++) {
                if(store[i][j] != '\u0000') sb.append(store[i][j]);
            }
        }
        return sb.toString();
    }
}
