class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new LinkedList<List<Integer>>();
        int[] currentLevel;
        int[] previousLevel = {0};
        for(int i = 0;i < numRows;i++) {
            currentLevel = new int[i+1];
            if(numRows == 1) {
                currentLevel[0] = 1;
            } else if(numRows == 2) {
                currentLevel[0] = 1;
                currentLevel[1] = 1;
            } else {
                currentLevel[0] = 1;
                for(int j = 1;j < i - 1;j++) {
                    currentLevel[j] = previousLevel[j-1]+previousLevel[j];
                }
                currentLevel[i - 1] = 1;
            }
            List<Integer> tempList = new LinkedList<Integer>();
            for(int j = 0;j < i;j++) {
                tempList.add(currentLevel[j]);
            }
            result.add(tempList);
            previousLevel = currentLevel;
        }
        return result;
    }
}
