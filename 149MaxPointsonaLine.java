/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
    
class Solution {
    class Two implements Comparable<Two>{
        int quo,rem;
        public Two(int quo,int rem) {
            this.quo = quo;
            this.rem = rem;
        }
        @Override
        public int compareTo(Two second) {
            if(this.quo == second.quo && this.rem == second.rem) return 0;
            else if(this.quo > second.quo || (this.quo == second.quo && this.rem > second.rem)) return 1;
            else return -1;
        }
    }
    public int maxPoints(Point[] points) {
        int n = points.length;
        if(n <= 1) return n;
        int result = 2;
        for(int i = 0;i < n;i++) {
            LinkedList<Two> ks = new LinkedList<>();
            Two k;
            int self = 0;
            for(int j = 0;j < n;j++) {
                k = getK(points[i],points[j]);
                if(k == null) self++;
                else ks.offerFirst(k);
            }
            result = Math.max(result,self);
            Collections.sort(ks);
            Two first;
            int counter;
            while(ks.size() != 0) {
                first = ks.pollFirst();
                counter = 1;
                while(ks.size() != 0 && first.quo == ks.peekFirst().quo && first.rem == ks.peekFirst().rem) {
                    counter++;
                    ks.pollFirst();
                }
                result = Math.max(result,self+counter);
            }
            
        }
        
        return result;
    }
    
    Two getK(Point p1,Point p2) {
        int up,down;
        if(p1.x == p2.x && p1.y == p2.y) {
            //p1,p2在同一个位置
            return null;
        } else if(p1.x == p2.x) {
            up = Integer.MAX_VALUE;
            down = Integer.MAX_VALUE;
            return new Two(up,down);
        } else {
            //其他情况
            boolean isPositive = false;
            up = p1.y-p2.y;
            down = p1.x-p2.x;
            if((up >= 0 && down >= 0) || (up <= 0 && down <= 0)) isPositive = true;
            else if(up < 0) up = -up;
            else down = - down;
            int g = gcd(up,down);
            up = up/g;
            down = down/g;
            if(isPositive) return new Two(up,down);
            else return new Two(-up,down);
        }
    }
    int gcd(int x, int y) {
        return (y == 0) ? x : gcd(y, x % y);
    }
}
