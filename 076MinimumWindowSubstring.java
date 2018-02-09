class Solution {
    public String minWindow(String s, String t) {
        //在匹配失败后最多地移动字符串
        HashMap<Character,Integer> dic = new HashMap<>();
        HashMap<Character,Integer> ref = new HashMap<>();
        for(int i = 0;i < t.length();i++) {
            if(dic.containsKey(t.charAt(i))) dic.put(t.charAt(i),dic.get(t.charAt(i))+1);
            else dic.put(t.charAt(i),1);
        }
        for(char c : dic.keySet()) {
            ref.put(c,0);
        }
        int resultlo = 0,resulthi = s.length();
        int lo = 0,hi;
        while(!dic.containsKey(s.charAt(lo))) lo++;
        hi = lo;
        boolean flag = false;
        while(lo < hi) {
            while(!contained(dic,ref)) {
                if(hi == s.length()) break;
                while(!ref.containsKey(s.charAt(hi))) hi++;
                if(ref.containsKey(s.charAt(hi)))
                    ref.put(s.charAt(hi),ref.get(s.charAt(hi))+1);
                hi++;
            }
            if(contained(dic,ref)) {
                flag = true;
                if(hi - lo < resulthi - resultlo) {
                    resultlo = lo;
                    resulthi = hi;
                }
            }
            ref.put(s.charAt(lo),ref.get(s.charAt(lo))-1);
            lo++;
            while(!ref.containsKey(s.charAt(lo))) lo++;
        }
        if(!flag) return "";
        else return s.substring(resultlo,resulthi);
    }
    
    boolean contained(HashMap<Character,Integer> dic,HashMap<Character,Integer> ref) {
        for(char c : dic.keySet()) {
            if(dic.get(c) > ref.get(c)) return false;
        }
        return true;
    }
    
}
