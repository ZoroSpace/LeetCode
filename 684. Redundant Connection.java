class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int m = edges.length;
        int ansU = 0,ansV = 0;
        
        UF uf = new UF(m+1);
        for(int i = 0;i < m;i++) {
            int p = edges[i][0],q = edges[i][1];
            if(uf.connected(p,q)) return edges[i];
            else uf.union(p,q);
        }
        return null;
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
