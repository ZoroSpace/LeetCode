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
    public int maxPoints(Point[] points) {
        int n = points.length;
        if(n <= 1) return n;
        int result = 2;
        for(int i = 0;i < n;i++) {
            LinkedList<Double> ks = new LinkedList<>();
            Double k;
            int self = 0;
            for(int j = 0;j < n;j++) {
                k = getK(points[i],points[j]);
                if(k == null) self++;
                else ks.offerFirst(k);
            }
            result = Math.max(result,self);
            Collections.sort(ks);
            double first;
            int counter;
            while(ks.size() != 0) {
                first = ks.pollFirst();
                counter = 1;
                while(ks.size() != 0 && equals(first,ks.peekFirst())) {
                    counter++;
                    ks.pollFirst();
                }
                result = Math.max(result,self+counter);
            }
            
        }
        
        return result;
    }
    
    Double getK(Point p1,Point p2) {
        if(p1.x == p2.x && p1.y == p2.y) {
            //p1,p2在同一个位置
            return null;
        } else if(p1.x == p2.x) {
            //p1,p2垂直于x轴
            return Double.MAX_VALUE;
        } else {
            //其他情况
            return (p1.y-p2.y)*1.0/(p1.x-p2.x);
        }
    }
    
    boolean equals(Double d1,Double d2) {
        if(Math.abs(d1-d2) < 1/10000000000.0) return true;
        else return false;
    }
}
