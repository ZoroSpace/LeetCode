public class Solution {
    public int findComplement(int num) {
        int n = 2;
        while(n - 1 < num) {
            n = n * 2;
        }
        return n - 1 - num;
    }
}
