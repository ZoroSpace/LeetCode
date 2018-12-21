class Solution {
    public int numIslands(char[][] grid) {
        if(grid.length == 0 || grid[0].length == 0) return 0;
        int m = grid.length,n = grid[0].length;
        UF uf = new UF(m*n);
        int ones = 0;
        for(int i = 0;i < m;i++) {
            for(int j = 0;j < n;j++) {
                if(grid[i][j] == '1') {
                    ones++;
                    if(i > 0 && grid[i-1][j] == '1') {
                        uf.union(j+i*n,j+(i-1)*n);
                    }
                    if(j > 0 && grid[i][j-1] == '1') {
                        uf.union(j+i*n,j+i*n-1);
                    }
                }
                
            }
        }
        return ones + uf.getCount() - m*n;
    }
    class UF {
        // weighted quick union with compressing path
        private int[] id;
        private int[] size;
        private int count;

        public UF(int N) {
            id = new int[N];
            size = new int[N];
            for (int i = 0; i < N; i++) {
                id[i] = i;
                size[i] = 1;
            }
            count = N;
        }

        public int getCount() {
            return count;
        }

        public boolean connected(int p,int q) {
            return find(p) == find(q);
        }

        public int find(int p) {
            while (p != id[p]) {
                id[p] = id[id[p]]; //*****
                p = id[p];
            }

            return p;
        }

        public void union(int p,int q) {
            int rootP = find(p);
            int rootQ = find(q);

            if (rootP == rootQ) return;
            if (size[rootP] > size[rootQ]) {
                id[rootQ] = rootP;
                size[rootP] += size[rootQ];
            } else {
                id[rootP] = rootQ;
                size[rootQ] += size[rootP];
            }
            count--;
        }
    }

}
