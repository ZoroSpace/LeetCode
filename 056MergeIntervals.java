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
    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size() == 0) return intervals;
        Collections.sort(intervals, new Comparator<Interval>(){
            @Override
            public int compare(Interval i1, Interval i2) {
                if(i1.start < i2.start) return -1;
                else if(i1.start == i2.start) return 0;
                else return 1;
            }
        });
        List<Interval> result = new LinkedList<>();
        Interval cur = intervals.get(0);
        for(Interval i : intervals) {
            if(cur.end < i.start) {
                result.add(cur);
                cur = i;
            } else {
                cur.end = Math.max(i.end,cur.end);
            }
        }
        result.add(cur);
        return result;
    }
}

