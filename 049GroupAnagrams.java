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
            cprChar1 = cpr.toCharArray();
            cprChar2 = cur.toCharArray();
            Arrays.sort(cprChar1);
            Arrays.sort(cprChar2);
            if(String.valueOf(cprChar1).equals(String.valueOf(cprChar2))) {
                list.add(cur);
                return lastResult;
            }
        }
        List<String> curStrs = new LinkedList<>();
        curStrs.add(cur);
        lastResult.add(curStrs);
        return lastResult;
    }
}
