//单向bfs
public class Solution {
    public List<List<String>> findLadders(String beginWord,String endWord,List<String> dict) {
        List<List<String>> result = new LinkedList<>();
        if(!dict.contains(endWord)) return result;
        Queue<LinkedList<String>> q = new LinkedList<>();
        LinkedList<String> elem = new LinkedList<>();
        HashSet<String> set = new HashSet<String>(dict);
        elem.offerFirst(beginWord);
        q.offer(elem);
        int size = q.size();
        LinkedList<String> cur;
        String last;
        String change;
        LinkedList plus;
        boolean found = false;
        //bfs
        while(q.size() != 0 && !found) {
            size = q.size();
            for(int i = 0;i < size;i++) {
                cur = q.poll();
                HashSet<String> curSet = new HashSet<String>(cur);
                last = cur.peekLast();
                for(int j = 0;j < last.length();j++) {
                    for(char k = 'a';k <= 'z';k++) {
                        if(k != last.charAt(j)) {
                            change = last.substring(0,j)+ k + last.substring(j+1,last.length());
                            if(!change.equals(beginWord) && !curSet.contains(change) && set.contains(change)) {
                                plus = (LinkedList)(cur.clone());
                                plus.offerLast(change);
                                q.offer(plus);
                                if(change.equals(endWord)) found = true;
                            }
                        }
                    }
                }                                                                                               
            }
        }
        for(LinkedList<String> list : q) {
            if(list.peekLast().equals(endWord)) result.add(list);
        }
        return result;
    }
}
