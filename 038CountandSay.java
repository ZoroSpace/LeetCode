class Solution {
    public String countAndSay(int n) {
        StringBuilder result ="";
        String lastResult = "1";
        if(n = 1) return lastResult;
        int counter = 0;
        char num = 0;
        for(int i = 1;i <n;i++) {
            num = lastResult.charAt(0);
            for(int j = 0;j < lastResult.length();j++) {
                if(num == lastResult.charAt(j)) counter++;
                else {
                    result.append(counter);
                    result.append(num);
                    counter = 1;
                    num = lastResult.charAt(j);
                }
            }
            lastResult = result;
        }
        return result;
    }
}
