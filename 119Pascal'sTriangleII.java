class Solution {
    public List<Integer> getRow(int rowIndex) {
        List<Integer> result = new LinkedList<>();
        int[] temp = new int[rowIndex+1];
        temp[0] = 1;
        long c;
        for(int i = 1;i < rowIndex/2+1;i++) {
            c = temp[i-1]/i * (rowIndex-i+1) + temp[i-1]%i * (rowIndex-i+1)/i;
            temp[i] = (int)c;
        }
        for(int i = rowIndex/2+1;i < rowIndex+1;i++) {
            temp[i]=temp[rowIndex-i];
        }
        for(int i = 0;i < temp.length;i++) {
            result.add(temp[i]);
        }
        return result;
    }
}
// class Solution {
//     public List<Integer> getRow(int rowIndex) {
//         List<Integer> result = new LinkedList<>();
//         long[] temp = new long[rowIndex+1];
//         temp[0] = 1;
//         long c;
//         for(int i = 1;i < rowIndex/2+1;i++) {
//             c = temp[i-1] * (rowIndex-i+1)/i;
//             temp[i] = c;
//         }
//         for(int i = rowIndex/2+1;i < rowIndex+1;i++) {
//             temp[i]=temp[rowIndex-i];
//         }
//         for(int i = 0;i < temp.length;i++) {
//             result.add((int)temp[i]);
//         }
//         return result;
//     }
// }
