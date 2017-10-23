public class Solution {
    public int hammingDistance(int x, int y) {
        int z = x^y;
        int counter = 0;
        while(z != 0) {
            counter = counter + z%2;
            z = z/2;
        }
        return counter;
    }
}
