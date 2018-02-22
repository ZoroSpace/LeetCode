class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        LinkedList<String> result = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
        for(int i = 0;i < words.length;i++) {
            list.offerLast(words[i]);
        }
        result.add(helper1(list,16));
        return result;
        
        
//         int counter;
//         int slow = 0,fast;
//         String begin = words[slow];
//         counter = begin.length();
//         list.offerFirst(begin);
//         for(fast = slow + 1;fast < words.length;fast++) {
//             counter = counter + 1 + words[fast].length();
//             list.offerFirst(fast);
//             if(counter > maxWidth) break;//也可能因为单词都添加完而执行完这段代码
//         }
//         list.pollLast();
//         counter = counter - words[fast] - 1;
//         int allSpace = maxWidth;
//         for(String s : list) {
//             allSpace = allSpace - s.length();
//         }
        
//         for(int i = 0;i < words.length;i++) {
            
//         }
    }
    
    String helper1(LinkedList<String> list,int maxWidth) {
        //对于非最后一行
        StringBuilder sb = new StringBuilder("");
        int allSpace = maxWidth;
        for(String s : list) allSpace = allSpace - s.length();
        int size = list.size();
        sb.append(list.pollFirst());
        if(size == 1) {
            for(int i = 0;i < allSpace;i++) sb.append(" ");
        } else {
            int m = allSpace/(size-1);
            int n = allSpace%(size-1);
            StringBuilder spacesb = new StringBuilder("");
            for(int i = 0;i < m;i++) spacesb.append(" ");
            for(int i = 0;i < n;i++) {
                sb.append(spacesb).append(" ").append(list.pollFirst());
            }
            for(int i = n;i < size - 1;i++) {
                sb.append(spacesb).append(list.pollFirst());
            }
        }
        return sb.toString();
    }
    String helper2(LinkedList<String> list,int maxWidth) {
        //对于最后一行
        StringBuilder sb = new StringBuilder("");
        int size = list.size();
        for(int i = 0;i < size;i++) {
            sb.append(list.peekFirst()).append(" ");
            maxWidth = maxWidth - 1 - list.pollFirst().length();
        }
        for(int i = 0;i < maxWidth;i++) sb.append(" ");
        return sb.toString();
    }
}
