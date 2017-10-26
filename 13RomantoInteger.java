class Solution {
    public int romanToInt(String s) {
        int a3 = 0;//千
        int a2 = 0;//百
        int a1 = 0;//十
        int a0 = 0;//个
        if(s.indexOf("VIII")!=-1) {
            a0 = 8;
            s = s.substring(0,s.length()-4);
        } else if(s.indexOf("III")!=-1) {
            a0 = 3;
            s = s.substring(0,s.length()-3);
        } else if(s.indexOf("VII")!=-1) {
            a0 = 7;
            s = s.substring(0,s.length()-3);
        } else if(s.indexOf("II")!=-1) {
            a0 = 2;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("IV")!=-1) {
            a0 = 4;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("VI")!=-1) {
            a0 = 6;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("IX")!=-1) {
            a0 = 9;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("I")!=-1) {
            a0 = 1;
            s = s.substring(0,s.length()-1);
        } else if(s.indexOf("V")!=-1) {
            a0 = 5;
            s = s.substring(0,s.length()-1);
        }
        
        if(s.indexOf("LXXX")!=-1) {
            a1 = 80;
            s = s.substring(0,s.length()-4);
        } else if(s.indexOf("XXX")!=-1) {
            a1 = 30;
            s = s.substring(0,s.length()-3);
        } else if(s.indexOf("LXX")!=-1) {
            a1 = 70;
            s = s.substring(0,s.length()-3);
        } else if(s.indexOf("XX")!=-1) {
            a1 = 20;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("XL")!=-1) {
            a1 = 40;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("LX")!=-1) {
            a1 = 60;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("XC")!=-1) {
            a1 = 90;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("X")!=-1) {
            a1 = 10;
            s = s.substring(0,s.length()-1);
        } else if(s.indexOf("L")!=-1) {
            a1 = 50;
            s = s.substring(0,s.length()-1);
        }
        
        if(s.indexOf("DCCC")!=-1) {
            a2 = 800;
            s = s.substring(0,s.length()-4);
        } else if(s.indexOf("CCC")!=-1) {
            a2 = 300;
            s = s.substring(0,s.length()-3);
        } else if(s.indexOf("DCC")!=-1) {
            a2 = 700;
            s = s.substring(0,s.length()-3);
        } else if(s.indexOf("CC")!=-1) {
            a2 = 200;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("CD")!=-1) {
            a2 = 400;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("DC")!=-1) {
            a2 = 600;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("CM")!=-1) {
            a2 = 900;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("C")!=-1) {
            a2 = 100;
            s = s.substring(0,s.length()-1);
        } else if(s.indexOf("D")!=-1) {
            a2 = 500;
            s = s.substring(0,s.length()-1);
        }
        
        if(s.indexOf("MMM")!=-1) {
            a3 = 3000;
            s = s.substring(0,s.length()-3);
        } else if(s.indexOf("MM")!=-1) {
            a3 = 2000;
            s = s.substring(0,s.length()-2);
        } else if(s.indexOf("M")!=-1) {
            a3 = 1000;
            s = s.substring(0,s.length()-1);
        }
        
        return a3+a2+a1+a0;
    }
}
