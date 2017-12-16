class Solution {
	public List<String> letterCombinations(String dig) {
		LinkedList<String> result = new LinkedList<>();
        if(dig.length() == 0) return result;
        char[] chArray = dig.toCharArray();
        char[] chArray2 = dig.toCharArray();
        Arrays.sort(chArray2);
        if(chArray2[0] < '2' || chArray2[dig.length()-1] > '9') return result;
        result.add(new String());
        String s0;
        String s1;
        String s2;
        String s3;
        for(char c : chArray) {
            int size = result.size();
            switch(c) {
                case '2':
                {
                    for(int i = 0;i < size;i++) {
                        s0 = result.poll();
                        s1 = s0 + 'a';
                        s2 = s0 + 'b';
                        s0 = s0 + 'c';
                        result.offer(s0);
                        result.offer(s1);
                        result.offer(s2);
                    }
                    break;
                }
                case '3':
                {
                    for(int i = 0;i < size;i++) {
                        s0 = result.poll();
                        s1 = s0 + 'd';
                        s2 = s0 + 'e';
                        s0 = s0 + 'f';
                        result.offer(s0);
                        result.offer(s1);
                        result.offer(s2);
                    }
                    break;
                }
                case '4':
                {
                    for(int i = 0;i < size;i++) {
                        s0 = result.poll();
                        s1 = s0 + 'g';
                        s2 = s0 + 'h';
                        s0 = s0 + 'i';
                        result.offer(s0);
                        result.offer(s1);
                        result.offer(s2);
                    }
                    break;
                }
                case '5':
                {
                    for(int i = 0;i < size;i++) {
                        s0 = result.poll();
                        s1 = s0 + 'j';
                        s2 = s0 + 'k';
                        s0 = s0 + 'l';
                        result.offer(s0);
                        result.offer(s1);
                        result.offer(s2);
                    }
                    break;
                }
                case '6':
                {
                    for(int i = 0;i < size;i++) {
                        s0 = result.poll();
                        s1 = s0 + 'm';
                        s2 = s0 + 'n';
                        s0 = s0 + 'o';
                        result.offer(s0);
                        result.offer(s1);
                        result.offer(s2);
                    }
                    break;
                }
                case '7':
                {
                    for(int i = 0;i < size;i++) {
                        s0 = result.poll();
                        s1 = s0 + 'p';
                        s2 = s0 + 'q';
                        s3 = s0 + 'r';
                        s0 = s0 + 's';
                        result.offer(s0);
                        result.offer(s1);
                        result.offer(s2);
                        result.offer(s3);
                    }
                    break;
                }
                case '8':
                {
                    for(int i = 0;i < size;i++) {
                        s0 = result.poll();
                        s1 = s0 + 't';
                        s2 = s0 + 'u';
                        s0 = s0 + 'v';
                        result.offer(s0);
                        result.offer(s1);
                        result.offer(s2);
                    }
                    break;
                }
                case '9':
                {
                    for(int i = 0;i < size;i++) {
                        s0 = result.poll();
                        s1 = s0 + 'w';
                        s2 = s0 + 'x';
                        s3 = s0 + 'y';
                        s0 = s0 + 'z';
                        result.offer(s0);
                        result.offer(s1);
                        result.offer(s2);
                        result.offer(s3);
                    }
                    break;
                }
                default: break;
            }
        }
        return result;
    }
}


