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

class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new LinkedList<>();
        HashMap<String,Integer> map =  new HashMap<>();
        int n = words[0].length();
        if(n == 0) {
            for(int i = 0;i <= s.length();i++) result.add(i);
            return result;
        }
        String next;
        String pre;
        for(int i = 0;i < n;i++) {
            int counter = 0;
            map.clear();
            for(String word:words) {
                counter++;
                if(map.containsKey(word)) map.put(word,map.get(word)+1);
                else map.put(word,1);
            }
            int slow = i,fast = slow;
            while(fast+n <= s.length()) {
                pre = s.substring(slow,slow+n);
                next = s.substring(fast,fast+n);
                if(map.containsKey(next)&&map.get(next) > 0) {
                    map.put(next,map.get(next)-1);
                    fast = fast+n;
                    counter--;
                    if(counter == 0) {
                        result.add(slow);
                        map.put(pre,map.get(pre)+1);
                        slow = slow+n;
                        counter++;
                    }
                } else {
                    if(slow == fast) {
                        slow = slow+n;
                        fast = slow;
                    } else {
                        map.put(pre,map.get(pre)+1);
                        slow = slow+n;
                        counter++;
                    }
                }
            }
        }
        return result;
    }
}
