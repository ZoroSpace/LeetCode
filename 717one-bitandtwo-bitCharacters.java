class Solution {
    public boolean isOneBitCharacter(int[] bits) {
        int i = 0;
        boolean flag = false;
        while(i < bits.length) {
            if(bits[i] == 0) {
                i++;
                flag = true;
            }
            else {
                i = i + 2;
                flag = false;
            }
        }
        return flag;
    }
}
