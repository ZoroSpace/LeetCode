class Solution {
    public int lengthOfLastWord(String s) {
        String[] result = s.split("\\s+");
        if(result.length == 0) return 0;
        else
            return result[result.length-1].length();
    }
}
