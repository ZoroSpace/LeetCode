public class Solution {
    public boolean judgeCircle(String moves) {
        int numberL = 0;
        int numberR = 0;
        int numberU = 0;
        int numberD = 0;
        for(int i = 0;i < moves.length();i++) {
            char temp = moves.charAt(i);
            if(temp == 'L') {
                numberL++;
            }
            else if(temp == 'R') {
                numberR++;
            }
            else if(temp == 'U') {
                numberU++;
            }
            else {
                numberD++;
            }
        }
        if(numberL == numberR && numberU == numberD) {
            return true;
        } else return false;
    }
}
