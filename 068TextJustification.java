class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        LinkedList<String> result = new LinkedList<>();
        LinkedList<String> list = new LinkedList<>();
        int cur = 0,counter = 0;
        String begin = words[cur];
        counter = begin.length();
        list.offerFirst(begin);
        while(cur < words.length) {
            if(counter <= maxWidth) {
                cur++;
                if(cur > words.length - 1) break;
                counter = counter + 1 + words[cur].length();
                list.offerLast(words[cur]);
            } else {
                list.pollLast();
                result.offerLast(helper1(list,maxWidth));
                begin = words[cur];
                counter = begin.length();
                list.offerFirst(begin);
            }
                
        }
        if(cur >= words.length - 1) result.offerLast(helper2(list,maxWidth));        
        return result;
    }
    
    String helper1(LinkedList<String> list,int maxWidth) {
        //对于非最后一行
        if(list.peekFirst().length() == maxWidth) return list.pollFirst();
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
        list.clear();
        return sb.toString();
    }
    String helper2(LinkedList<String> list,int maxWidth) {
        //对于最后一行
        if(list.peekFirst().length() == maxWidth) return list.pollFirst();
        StringBuilder sb = new StringBuilder("");
        int size = list.size();
        for(int i = 0;i < size;i++) {
            sb.append(list.peekFirst()).append(" ");
            maxWidth = maxWidth - 1 - list.pollFirst().length();
        }
        for(int i = 0;i < maxWidth;i++) sb.append(" ");
        list.clear();
        return sb.toString();
    }
}
