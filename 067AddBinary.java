class Solution {
    public String addBinary(String a, String b) {
        boolean flag = false;
        if(a.length() < b.length()) {
            flag = true;
        }
        int shortLength = a.length() < b.length()? a.length():b.length();
        int longLength = a.length() > b.length()? a.length():b.length();
        int c = 0;
        StringBuilder sb = new StringBuilder();
        int d = 0;
        int aNum;
        int bNum;
        for(int i = shortLength - 1;i > -1;i--) {
            aNum = Character.getNumericValue(a.charAt(i));
            bNum = Character.getNumericValue(b.charAt(i));
            d = c + aNum + bNum;
            switch(d) {
                case 3:
                    sb.append(1);
                    c = 1;
                    break;
                case 2:
                    sb.append(0);
                    c = 1;
                    break;
                default:
                    sb.append(d);
                    c = 0;
                    break;
            }
        }
        if(flag) {
            for(int i = longLength - 1;i > shortLength - 1;i--) {
                sb.append(b.charAt(i) + c);
                c = 0;
            }
        } else {
            for(int i = longLength - 1;i > shortLength - 1;i--) {
                sb.append(a.charAt(i) + c);
                c = 0;
            }
        }
        return sb.reverse().toString();
        
    }
}
