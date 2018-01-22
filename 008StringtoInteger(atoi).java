class Solution {
    public int myAtoi(String str) {
        //功能: 将字符串转换成整型数；atoi()会扫描参数nptr字符串，跳过前面的空格字符，直到遇上数字或正负号才开始做转换，而再遇到非数字或'\0'才结束转化，并将结果返回（返回转换后的整型数）。
        //If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.
        char[] ch = str.toCharArray();
        StringBuilder result = new StringBuilder("");
        int i = 0;
        boolean flag = true;
        for(;i < ch.length;i++) {
            if(ch[i] != ' ') break;
        }
        if(i == ch.length) return 0;
        if(ch[i] != '+' && ch[i] != '-' && (ch[i] > '9' || ch[i] < '0')) return 0;
        if(ch[i] == '-') {
            flag = false;
            i++;
        } else if(ch[i] == '+') i++;
        for(;i < ch.length;i++) {
            if(ch[i] >= '0' && ch[i] <= '9') result.append(ch[i]);
            else break;
        }
        if(result.length() == 0) return 0;
        if(result.length() > 13) {
            if(flag) return Integer.MAX_VALUE;
            else return Integer.MIN_VALUE;
        }
        long n = Long.parseLong(result.toString());
        if(flag && n > Integer.MAX_VALUE) return Integer.MAX_VALUE;
        if(!flag && -n <= Integer.MIN_VALUE) return Integer.MIN_VALUE;
        if(flag) return (int) n;
        else return (int)(-n);
    }
}
