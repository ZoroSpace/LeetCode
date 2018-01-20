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
        List<String> curStep = new LinkedList<>();
        List<String> nextStep = wordList;
        curStep.add(beginWord);
        int result = 2;
        List<String> curTemp = new LinkedList<>();
        List<String> nextTemp = new LinkedList<>();
        while(curStep.size() != 0) {
            curTemp = new LinkedList<>();
            nextTemp = new LinkedList<>();
            for(String s1 : curStep) {
                if(helper(s1,endWord)) return result;
                for(String s2 : nextStep) {
                    if(helper(s1,s2)) curTemp.add(s2);
                    else nextTemp.add(s2);
                }
            }
            curStep = curTemp;
            nextStep = nextTemp;
            result++;
        }
        return 0;
    }
    
    boolean helper(String s1,String s2) {
        //检查s1和s2的“距离”是不是1
        int counter = 0;
        for(int i = 0;i < s1.length();i++) {
            if(s1.charAt(i) != s2.charAt(i)) counter++;
            if(counter == 2) return false;
        }
        return counter == 1;
    }
}
