class Solution {
    public int findCircleNum(int[][] M) {
        int N = M.length;
        UF uf = new UF(N);
        for(int i = 0;i < N;i++) {
            for(int j = i+1;j < N;j++) {
                if(M[i][j] == 1) uf.union(i,j);
            }
        }
        return uf.getCount();
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
