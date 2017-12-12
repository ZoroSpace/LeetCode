class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> lastResult = new LinkedList<>();
        if(strs.length == 0) return new LinkedList<>();
        String cur = strs[strs.length - 1];
        String[] lastStrs = new String[strs.length - 1];
        System.arraycopy(strs,0,lastStrs,0,strs.length - 1);
        lastResult = groupAnagrams(lastStrs);
        String cpr;//compare
        char[] cprChar1;
        char[] cprChar2;
        for(List<String> list : lastResult) {
            cpr = ((LinkedList<String>)list).getFirst();
            if(cpr.length() == cur.length()) {
                cprChar1 = cpr.toCharArray();
                cprChar2 = cur.toCharArray();
                Arrays.sort(cprChar1);
                Arrays.sort(cprChar2);
                if(String.valueOf(cprChar1).equals(String.valueOf(cprChar2))) {
                    list.add(cur);
                    return lastResult;
                }
            }
        }
        List<String> curStrs = new LinkedList<>();
        curStrs.add(cur);
        lastResult.add(curStrs);
        return lastResult;
    }
}

class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        if(strs.length == 0) return new LinkedList<>();
        Map<String,LinkedList<String>> map = new HashMap<>();
        for(String s : strs) {
            char[] ch = s.toCharArray();
            Arrays.sort(ch);
            String key = String.valueOf(ch);
            if(!map.containsKey(key)) map.put(key,new LinkedList<String>());
            map.get(key).add(s);
        }
        return new LinkedList<List<String>>(map.values());
    }
}
