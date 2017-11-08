class Solution {
    public String countAndSay(int n) {
        StringBuilder result = new StringBuilder();
        String lastResult = "1";
        if(n == 1) return lastResult;
        else {
            int counter = 0;
            char num = 0;
            for(int i = 1;i <n;i++) {
                result = new StringBuilder();
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
                result.append(counter);
                result.append(num);
                lastResult = result.toString();
            }
            return result.toString();
        }
        
    }
}
