public class Solution {
    public String reverseWords(String s) {
        s = s.trim();
        String[] strs = s.split("\\s+");
        if(strs.length == 0) return " ";
        if(strs.length == 1) return strs[0];
        StringBuilder ans = new StringBuilder();
        for(int i = strs.length-1;i >= 1;i--) {
            ans.append(strs[i]).append(" ");
        }
        ans.append(strs[0]);
        return ans.toString();
    }
}
