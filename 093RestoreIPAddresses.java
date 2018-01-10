class Solution {
    public List<String> restoreIpAddresses(String s) {
        int n = s.length();
        List<String> result = new LinkedList<>();
        String s1;
        String s2;
        if(n < 4) return result;
        for(int i = Math.max(1,n-9);i <= Math.min(3,n-3);i++) {
            s1 = s.substring(0,i);
            if(Integer.parseInt(s1) <= 255) {
                s2 = s.substring(i);
                List<String> level1 = helper1(s2);
                if(level1.size() != 0) {
                    for(String l1 : level1) {
                        result.add(s1+"."+l1);
                    }
                }
            }
        }
        return result;
    }
    
    List<String> helper1(String s) {
        int n = s.length();
        List<String> result = new LinkedList<>();
        String s1;
        String s2;
        for(int i = Math.max(1,n-6);i <= Math.min(3,n-2);i++) {
            s1 = s.substring(0,i);
            if(Integer.parseInt(s1) <= 255) {
                s2 = s.substring(i);
                List<String> level2 = helper2(s2);
                if(level2.size() != 0) {
                    for(String l2 : level2) {
                        result.add(s1+"."+l2);
                    }
                }
            }
        }
        return result;
    }
    
    List<String> helper2(String s) {
        int n = s.length();
        List<String> result = new LinkedList<>();
        String s1;
        String s2;
        for(int i = Math.max(1,n-3);i <= Math.min(3,n-1);i++) {
            s1 = s.substring(0,i);
            if(Integer.parseInt(s1) <= 255) {
                s2 = s.substring(i);
                List<String> level3 = helper3(s2);
                if(level3.size() != 0) {
                    for(String l3 : level3) {
                        result.add(s1+"."+l3);
                    }
                }
            }
        }
        return result;
    }
    
    List<String> helper3(String s) {
        List<String> result = new LinkedList<>();
        if(Integer.parseInt(s) <= 255) result.add(s);
        return result;
    }
}
