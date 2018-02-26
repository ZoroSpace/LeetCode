//单向bfs
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<List<String>> result = new LinkedList<>();
        HashSet<String> visited = new HashSet<>();
        HashSet<String> dict = new HashSet<>(wordList);
        Queue<LinkedList<String>> q = new LinkedList<>();
        LinkedList<String> first = new LinkedList<>();
        first.offerFirst(beginWord);
        q.offer(first);
        visited.add(beginWord);
        boolean found = false;
        while(q.size() != 0 && !found) {
            int size = q.size();
            HashSet<String> set = new HashSet<>();
            for(int i = 0;i < size;i++) {
                LinkedList<String> cur = q.poll();
                String last = cur.peekLast();
                char[] ch = last.toCharArray();
                for(int j = 0;j < last.length();j++) {
                    for(char c = 'a';c <= 'z';c++) {
                        if(c != ch[j]) {
                            ch[j] = c;
                            String change = String.valueOf(ch);
                            ch[j] = last.charAt(j);
                            if(!visited.contains(change) && dict.contains(change)) {
                                LinkedList<String> list = (LinkedList<String>)(cur.clone());
                                list.offerLast(change);
                                q.offer(list);
                                set.add(change);
                                if(change.equals(endWord)) {
                                    result.add(list);
                                    found = true;
                                }
                            }
                        }
                    }
                }
                
            }
            visited.addAll(set);
        }
        return result;
    }
}
