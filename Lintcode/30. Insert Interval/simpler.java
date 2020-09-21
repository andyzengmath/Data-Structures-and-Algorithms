class simpler {
    public List<Interval> insert(List<Interval> intervals, Interval newInterval) {
        List<Interval> newIntervals = new ArrayList<Interval>();
        if (intervals.size() == 0) {
            newIntervals.add(newInterval);
        }

        for (int i = 0; i < intervals.size(); i++) {
            if (newInterval.end < intervals.get(i).start) {
                newIntervals.add(newInterval);
                for (int j = i; j < intervals.size(); j++) {
                    newIntervals.add(intervals.get(j));
                }
                break;
            } else if (newInterval.start > intervals.get(i).end) {
                newIntervals.add(intervals.get(i));
            } else {
                newInterval.start = Math.min(newInterval.start, intervals.get(i).start);
                newInterval.end = Math.max(newInterval.end, intervals.get(i).end);
            }

            if (i == intervals.size() - 1) {
                newIntervals.add(newInterval);
            }

        }
        return newIntervals;
    }
}