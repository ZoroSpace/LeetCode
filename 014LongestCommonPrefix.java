class Solution {
    public String longestCommonPrefix(String[] strs) {
        if(strs.length == 0) return "";
        String result = strs[0];
        for(int i = 0;i < strs.length;i++) {
            result = helper(strs[i],result);
            if(result.length() == 0) return result;
        }
        return result;
    }
    public String helper(String s1,String s2) {
        StringBuilder sb = new StringBuilder();
        int length = s1.length() < s2.length()?s1.length():s2.length();
        for(int i = 0;i < length;i++) {
            if(s1.charAt(i) == s2.charAt(i)) sb.append(s1.charAt(i));
            else break;
        }
        return sb.toString();
    }
}
// class Solution {
//     public String longestCommonPrefix(String[] strs) {
//         if(strs.length == 0) return "";
//         Arrays.sort(strs);
//         while(strs[strs.length-1].indexOf(strs[0]) != 0)
//             strs[0] = strs[0].substring(0,strs[0].length()-1);
//         return strs[0];
//     }
// }
