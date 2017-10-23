public class Solution {
    public int distributeCandies(int[] candies) {
        HashSet<Integer> set = new HashSet<>();
        for(int i : candies) {
            set.add(i);
        }
        return Math.min(candies.length/2,set.size());
    }
}
