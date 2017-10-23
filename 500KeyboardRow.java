public class Solution {
    public String[] findWords(String[] words) {
        String alphabet1 = "qwertyuiopQWERTYUIOP";
        String alphabet2 = "asdfghjklASDFGHJKL";
        String alphabet3 = "zxcvbnmZXCVBNM";
        boolean flag;
        LinkedList<String> oneLine = new LinkedList<>();
        for(String s : words) {
            flag = true;
            if(alphabet1.indexOf(s.charAt(0) + "") != -1) {
                for(int i = 1;i<s.length();i++) {
                    if(alphabet1.indexOf(s.charAt(i) + "") == -1) {
                        flag = false;
                    }
                }
            } else if(alphabet2.indexOf(s.charAt(0) + "") != -1) {
                for(int i = 1;i<s.length();i++) {
                    if(alphabet2.indexOf(s.charAt(i) + "") == -1) {
                        flag = false;
                    }
                }
            } else {
                for(int i = 1;i<s.length();i++) {
                    if(alphabet3.indexOf(s.charAt(i) + "") == -1) {
                        flag = false;
                    }
                }
            }
            if(flag == true) oneLine.add(s);
        }
        return oneLine.toArray(new String[oneLine.size()]);
    }
}
