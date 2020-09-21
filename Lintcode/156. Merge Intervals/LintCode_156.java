/**
 * Definition of Interval:
 * public class Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */
public class LintCode_156 {
    /**
     * @param intervals: interval list.
     * @return: A new interval list.
     * O(n log n) time and O(1) extra space.

     */
    public List<Interval> merge(List<Interval> intervals) {
        // write your code here
        if (intervals.size() == 0) {
            return intervals;
        } 
        
        intervals.sort(Comparator.comparing(i -> i.start));
        List<Interval> result = new ArrayList<Interval>();
        Interval lastInterval = intervals.get(0);

        for (Interval interval: intervals) {
            if (haveIntercation(lastInterval, interval)) {
                lastInterval = mergeTwoIntervals(lastInterval, interval);
            } else {
                result.add(lastInterval);
                lastInterval = interval;
            }
        }
        result.add(lastInterval);
        
        return result;
    }

    private Interval mergeTwoIntervals(Interval a, Interval b) {
        return new Interval(Math.min(a.start, b.start), Math.max(a.end, b.end));
    }
    private boolean haveIntercation(Interval a, Interval b) {
        return Math.max(a.start, b.start) <= Math.min(a.end, b.end);
    }
}