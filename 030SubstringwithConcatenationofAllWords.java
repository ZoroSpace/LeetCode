class Solution {
    HashSet<Integer> set;
    public List<Integer> findSubstring(String s, String[] words) {
        set = new HashSet<>();
        List<Integer> result = new LinkedList<>();
        if(s.length()<words.length*words[0].length()) return result;
        boolean[] visited = new boolean[words.length];
        for(int i = 0;i < s.length();i++) {
            for(int j = 0;j < words.length;j++) {
                if(!visited[j] && s.startsWith(words[j],i)) {
                    visited[j] = true;
                    helper2(s,words,i+words[0].length(),visited);
                    visited[j] = false;
                }
            }
        }
        
        result.addAll(set); 
        if(words[0].length()==0) result.add(s.length());
        return result;
    }
    
    void helper2(String s,String[] words,int index,boolean[] visited) {
        int m = words.length;
        int n = s.length();
        int p = words[0].length();
        if(index > n) return;
        boolean flag = true;
        for(int i = 0;i < m;i++) {
            if(!visited[i]) {
                flag = false;
                break;
            }
        }
        if(flag) {
            set.add(index-m*p);
            return;
        }
        for(int j = 0;j < m;j++) {
            if(!visited[j] && s.startsWith(words[j],index)) {
                visited[j] = true;
                helper2(s,words,index+p,visited);
                visited[j] = false;
            }
        }
    }
}
