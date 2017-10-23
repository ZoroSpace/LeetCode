class Solution {
    public List<String> fizzBuzz(int n) {
        List<String> string = new ArrayList<String>();
        for(int i = 1;i<=n;i++) {
            if(i % 15 == 0) {
                string.add("FizzBuzz");
                continue;
            }
            if(i % 5 == 0) {
                string.add("Buzz");
                continue;
            }
            if(i % 3 == 0) {
                string.add("Fizz");
                continue;
            }
            string.add(""+i);
        }
        return string;
    }
}
