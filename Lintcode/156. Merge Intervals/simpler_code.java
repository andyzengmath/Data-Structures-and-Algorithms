public class simpler_code {
    public List<Interval> merge(List<Interval> intervals) {
        if (intervals == null || intervals.size() <= 1) {
            return intervals;
        }

        intervals.sort((o1, o2) -> o1.start - o2.start);
        List<Interval> result = new ArrayList<>();
        Interval last = null;

        for (Interval interval: intervals) {
            if (last == null || last.end < interval.start) {
                result.add(interval);
                last = interval;
            } else {
                last.end = Math.max(last.end, interval.end);
            }
        }

        return result;
    }
}