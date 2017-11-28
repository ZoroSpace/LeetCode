class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> result = new LinkedList<>();
        int num = (int)Math.pow(2,n);
        int j;
        for(int i = 0;i < num;i++) {
            j = i>>1;
            result.add(i^j);
        }
        return result;
    }
}
