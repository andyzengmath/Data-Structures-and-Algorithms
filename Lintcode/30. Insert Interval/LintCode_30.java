/**
 * Definition of Interval:
 * public classs Interval {
 *     int start, end;
 *     Interval(int start, int end) {
 *         this.start = start;
 *         this.end = end;
 *     }
 * }
 */

public class LintCode_30 {
    /** Leet-57
     * not passed!
     * @param intervals: Sorted interval list.
     * @param newInterval: new interval.
     * @return: A new interval list.
     */
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        // write your code here
        List<Interval> result = new ArrayList<>();
        if (intervals == null) {
            return result;
        } else if (intervals.size() == 0) {
            result.add(newInterval);
            return result;
        }

        for (Interval interval: intervals) {
            result.add(interval);
            if (!haveIntersection(interval, newInterval)) {
                continue;
            } else {
                merge(interval, newInterval);
                newInterval = interval;
            }
        }

        return result;


    }

    private boolean haveIntersection(Interval v1, Interval v2) {
        return Math.max(v1.start, v2.start) <= Math.min(v1.end, v2.end);
    }

    private void merge(Interval original, Interval newInterval) {
        original.end = Math.max(original.end, newInterval.end);
        original.start = Math.min(original.start, newInterval.start);
    }
}