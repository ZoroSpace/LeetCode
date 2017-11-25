class Solution {
    public String intToRoman(int nums) {
        String[] rs  = {"I","II","III","IV","V","VI","VII","VIII","IX","X","XX","XXX","XL","L","LX","LXX","LXXX","XC","C","CC","CCC","CD","D","DC","DCC","DCCC","CM","M","MM","MMM"};
        StringBuilder result = new StringBuilder();
        int i = 0;
        while(nums != 0) {
            if(nums % 10 != 0) {
                result.insert(0,rs[nums % 10 + i * 9 - 1]);
            }
                nums = nums/10;
                i++;
            
        }
        return result.toString();
        
    }
        
        
}
