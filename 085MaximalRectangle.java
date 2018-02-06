public class Solution {
	public int maximalRectangle(char[][] matrix) {
		if(matrix.length == 0|| matrix[0].length == 0) return 0;
		int m = matrix.length,n = matrix[0].length;
        HashSet<Integer>[][] list = new HashSet[m+1][n+1];
        int min = m*n;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(matrix[i][j] == '0') list[i+1][j+1] = null;
                else {
                    list[i+1][j+1] = new HashSet<>();
                    list[i+1][j+1].add(i*n+j);
                    if(list[i][j+1] == null && list[i+1][j] == null) {
                    } else if(list[i][j+1] == null) {
                        for(int k : list[i+1][j]) {
                            if(k/n==i) list[i+1][j+1].add(k);
                        }
                    } else if(list[i+1][j] == null) {
                        for(int k : list[i][j+1]) {
                            if(k%n==j) list[i+1][j+1].add(k);
                        }
                    } else {
                        int minr = m,minc = n;
                        for(int k : list[i][j+1]) {
                            minr = Math.min(minr,k/n);
                        }
                        for(int k : list[i+1][j]) {
                            minc = Math.min(minc,k%n);
                        }
                        for(int k : list[i][j+1]) {
                            if(k%n>=minc) list[i+1][j+1].add(k);
                        }
                        for(int k : list[i+1][j]) {
                            if(k/n>=minr) list[i+1][j+1].add(k);
                        }
                    }
                }
            }
        }
        int result = 0;
        int r,c;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(matrix[i][j] == '1') {
                    for(int k : list[i+1][j+1]) {
                        r = k/n;
                        c = k%n;
                        result = Math.max(result,(i-r+1)*(j-c+1));
                    }
                }
            }
        }
        return result;
	}
}

