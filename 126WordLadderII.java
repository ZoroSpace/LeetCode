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
//双向bfs
class Solution {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        LinkedList<List<String>> result = new LinkedList<>();
        HashSet<String> dict = new HashSet(wordList);
        if(!dict.contains(endWord)) return result;
        Queue<LinkedList<String>> queueF = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
        list.offerFirst(beginWord);
        queueF.offer(list);
        HashSet<String> visitedF = new HashSet<>();
        visitedF.add(beginWord);
        
        Queue<LinkedList<String>> queueB = new LinkedList<>();
        list = new LinkedList<>();
        list.offerLast(endWord);
        queueB.offer(list);
        HashSet<String> visitedB = new HashSet<>();
        visitedB.add(endWord);
        boolean found = false;
        HashSet<String> setF = new HashSet<>();
        HashSet<String> setB = new HashSet<>();
        setB.add(endWord);
        while(queueF.size() != 0 && queueB.size() != 0 && !found) {
            int sizeF = queueF.size();
            for(int i = 0;i < sizeF;i++) {
                list = queueF.poll();
                String last = list.peekLast();
                char[] ch = last.toCharArray();
                for(int j = 0;j < last.length();j++) {
                    for(char c = 'a';c <= 'z';c++) {
                        if(c != ch[j]) {
                            ch[j] = c;
                            String change = String.valueOf(ch);
                            ch[j] = last.charAt(j);
                            if(!visitedF.contains(change) && dict.contains(change)) {
                                LinkedList<String> cur = (LinkedList<String>)(list.clone());
                                cur.offerLast(change);
                                queueF.offer(cur);
                                setF.add(change);
                                if(setB.contains(change)) {
                                    combine(result,queueB,cur,change,true);
                                    found = true;
                                }
                            }
                        }
                    }
                }
            }
            visitedF.addAll(setF);
            setB.clear();
            if(found) break;
            int sizeB = queueB.size();
            for(int i = 0;i < sizeB;i++) {
                list = queueB.poll();
                String last = list.peekFirst();
                char[] ch = last.toCharArray();
                for(int j = 0;j < last.length();j++) {
                    for(char c = 'a';c <= 'z';c++) {
                        if(c != ch[j]) {
                            ch[j] = c;
                            String change = String.valueOf(ch);
                            ch[j] = last.charAt(j);
                            if(!visitedB.contains(change) && dict.contains(change)) {
                                LinkedList<String> cur = (LinkedList<String>)(list.clone());
                                cur.offerFirst(change);
                                queueB.offer(cur);
                                setB.add(change);
                                if(setF.contains(change)) {
                                    combine(result,queueF,cur,change,false);
                                    found = true;
                                }
                            }
                        }
                    }
                }
            }
            visitedB.addAll(setB);
            setF.clear();
            
        }
        return result;
        
    }
    void combine(LinkedList<List<String>> result,Queue<LinkedList<String>> queue,LinkedList<String> list,String change,boolean after) {
        LinkedList<String> com;
        if(after) {
            for(LinkedList<String> l : queue) {
                if(l.peekFirst().equals(change)) {
                    com = new LinkedList<>();
                    for(String s : list) com.offerLast(s);
                    com.pollLast();
                    for(String s : l)  com.offerLast(s);
                    result.add(com);
                }
            }
        } else {
            for(LinkedList<String> l : queue) {
                if(l.peekLast().equals(change)) {
                    com = new LinkedList<>();
                    for(String s : l)  com.offerLast(s);
                    com.pollLast();
                    for(String s : list) com.offerLast(s);
                    result.add(com);
                }
            }
        }
        return;
    }
}
