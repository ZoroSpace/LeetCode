/**
 * Definition for an interval.
 * public class Interval {
 *     int start;
 *     int end;
 *     Interval() { start = 0; end = 0; }
 *     Interval(int s, int e) { start = s; end = e; }
 * }
 */
class Solution {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> result = new LinkedList<>();
        boolean flag = true;
        
        for(Interval i : intervals) {
            if(i.end < newInterval.start || i.start > newInterval.end) {
                result.add(i);//1
            }
            else if(i.start >= newInterval.start && i.end <= newInterval.end) continue;//2
            else if(i.start <= newInterval.start && i.end >= newInterval.end) {//3
                result.add(i);
                flag = false;
            } else if(i.end >= newInterval.end) newInterval.end = i.end;//4
            else newInterval.start = i.start;//5
            
        }
        if(flag) result.add(newInterval);
        Collections.sort(result,new Comparator<Interval> (){
            @Override
            public int compare(Interval i1, Interval i2) {                
                return i1.start-i2.start;
            }
        });
        return result;
    }
}
