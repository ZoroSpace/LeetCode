class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        boolean flag = false;
        for(String s : wordList) {
            if(endWord.equals(s)) {
                flag = true;
                break;
            }
        }
        if(!flag) return 0;
        
        HashMap<String,Boolean> visited = new HashMap<>();
        for(String s : wordList) visited.put(s,false);
        
        int result = 2;
        
        LinkedList<String> list = new LinkedList<>();
        list.offer(beginWord);
        
        int size;
        String cur;
        String changed;
        char[] curCharArray;
        while(list.size() != 0) {
            size = list.size();
            for(int i = 0;i < size;i++) {
                cur = list.poll();
                for(int j = 0;j < cur.length();j++) {
                    for(char c = 'a';c <= 'z';c++) {
                        if(c == cur.charAt(j)) continue;
                        curCharArray = cur.toCharArray();
                        curCharArray[j] = c;
                        changed = String.valueOf(curCharArray);
                        if(changed.equals(endWord)) return result;
                        if(visited.containsKey(changed) && !visited.get(changed)) {
                            visited.put(changed,true);
                            list.offer(changed);
                        }
                    }
                }
            }
            result++;
        }
        return 0;
    }
}
