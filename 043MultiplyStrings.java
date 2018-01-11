class Solution {
    public String multiply(String num1, String num2) {
        int n1 = num1.length();
        int n2 = num2.length();
        char[] cs1 = num1.toCharArray();
        char[] cs2 = num2.toCharArray();
        if(cs1[0] == '0' || cs2[0] == '0') return "0";//要考虑其中一个是0的情况
        int[] result = new int[n1 + n2 -1];
        for(int i = n1 + n2 -2;i > -1;i--) {
            for(int j = n2 - 1;0 <= i-j && i-j <= n1-1;j--) {
                result[i] = (cs2[j] - '0') * (cs1[i-j] - '0');
            }
        }
        int c = 0;
        StringBuilder sb = new StringBuilder("");
        for(int i = n1 + n2 - 2;i > -1;i--) {
            sb.append(c+result[i] % 10);
            c = result[i]/10;
        }
        if(c != 0) sb.append(c);
        return sb.reverse().toString();
    }
}
