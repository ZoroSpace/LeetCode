class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n <= 1) return n;
        boolean[] L = new boolean[n];
        boolean[] R = new boolean[n];
        for(int i = 0;i < n-1;i++) {
            if(ratings[i] < ratings[i+1]) L[i+1] = true;
            if(ratings[i] > ratings[i+1]) R[i] = true;
        }
        int[] c = new int[n];
        c[0] = 1;
        for(int i = 1;i < n;i++) {
            if(L[i]) c[i] = c[i-1]+1;
            else c[i] = 1;
        }
        for(int i = n-2;i > -1;i--) {
            if(R[i]) c[i] = Math.max(c[i],c[i+1]+1);
        }
        int result = 0;
        for(int i = 0;i < n;i++) {
            result += c[i];
        }
        return result;
    }
}


class Solution {
    public int candy(int[] ratings) {
        int n = ratings.length;
        if(n <= 1) return n;
        int[] c = new int[n];
        c[0] = 1;
        for(int i = 1;i < n;i++) {
            if(ratings[i]>ratings[i-1]) c[i] = c[i-1]+1;
            else c[i] = 1;
        }
        int result = c[n-1];
        for(int i = n-2;i > -1;i--) {
            if(ratings[i]>ratings[i+1]) c[i] = Math.max(c[i],c[i+1]+1);
            result += c[i];
        }
        return result;
    }
}
