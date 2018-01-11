class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        if(cs1[0] == '0' || cs2[0] == '0') return "0";//要考虑其中一个是0的情况
        int[] result = new int[n1 + n2 -1];
        for(int i = 0;i < n1+n2-1;i++) {
            result[i] = 0;
            for(int j = Math.max(0,i+1-n2);j <= i && j < n1;j++) {
                result[i] = result[i] + (cs1[j] - 48) * (cs2[i-j] - 48);
            }
        }
        int c = 0;
        StringBuilder sb = new StringBuilder("");
        for(int i = n1 + n2 - 2;i > -1;i--) {
            sb.append((c+result[i]) % 10);
            c = (c+result[i])/10;
        }
        if(c != 0) sb.append(c);
        return sb.reverse().toString();
    }
}
