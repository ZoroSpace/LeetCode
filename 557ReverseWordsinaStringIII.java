public class Solution {
    public String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";
        for(String word : words) {
            word = new StringBuffer(word).reverse().toString();
            result = result + word + " ";
        }
        return result.substring(0,result.length() - 1);
    }
}
