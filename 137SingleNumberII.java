class Solution {
    public int singleNumber(int[] A) {
        int ones = 0, twos = 0;
        for(int i = 0; i < A.length; i++){
            ones = (ones ^ A[i]) & ~twos;
            twos = (twos ^ A[i]) & ~ones;
        }
        return ones;
    }
}
class Solution {
    public int singleNumber(int[] nums) {
        int na = 0, nb = 0, nc = 0;
        int a = 0, b = 0, c = 0;
        for(int i = 0; i < nums.length; i++){
            na = (a & ~b & ~c & ~nums[i]) |(~a & b & c & nums[i]);
            nb = (~a & ~b & c & nums[i]) | (~a & b & ~c) | (~a & b & c & ~nums[i]);
            nc = (~a & ~b & ~c & nums[i]) |(~a & ~b & c & ~nums[i]) |(~a & b & ~c & nums[i]) |(~a & b & c & ~nums[i]);
            a = na;
            b = nb;
            c = nc;
        }
        return c;
    }

}
class Solution {
    public int singleNumber(int[] nums) {
        int na = 0, nb = 0, nc = 0;
        int a = 0, b = 0, c = 0;
        for(int i = 0; i < nums.length; i++){
            na = (a & ~nums[i]) |(~a & b & c & nums[i]);
            nb = (~a & ~b & c & nums[i]) | (~a & b & ~c) | (~a & b & c & ~nums[i]);
            nc = ~a & (nums[i] ^ c);
            a = na;
            b = nb;
            c = nc;
        }
        return c;
    }
}
