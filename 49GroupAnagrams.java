class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new LinkedList<>();
        if(strs.length == 0) return result;
        else return helper(strs);
    }
    
    List<List<String>> helper(String[] strs) {
        List<List<String>> lastResult = new LinkedList<>();
        String cur = strs[strs.length - 1];
        String[] lastStrs = new String[strs.length - 1];
        System.arraycopy(strs,0,lastStrs,0,strs.length - 1);
        lastResult = helper(lastStrs);
        String cpr;//compare
        char[] cprChar;
        for(List<String> list : lastResult) {
            list = (LinkedList)list;
            cpr = list.getFirst;
            cprChar = cahrcpr.toCharArray();
            Arrays.sort(cprChar);
            if(String.valueOf(cprChar) == cur) {
                list.add(cur);
                return lastResult;
            }
        }
        List<String> curStrs = new LinkedList<>();
        curStrs.add(cur);
        
    }
}
