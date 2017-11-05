class Solution {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        int counter = 0;
        for(int i = digits.length - 1;i > -1;i--) {
            if(digits[i] + carry <= 9) {
                digits[i] = digits[i] + carry;
                break;
            } else {
                digits[i] = 0;
                counter++;
            }
        }
        if(counter == digits.length) {
            digits = new int[digits.length+1];
            digits[0] = 1;
            for(int i = 1;i < digits.length;i++) {
                digits[i] = 0;
            }
        }
        return digits;
    }
}
