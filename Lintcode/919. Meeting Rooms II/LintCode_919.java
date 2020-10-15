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

public class LintCode_919 {
    /** Leet 253
     * @param intervals: an array of meeting time intervals
     * @return: the minimum number of conference rooms required
     */
    static class Node {
        public int time;
        public int cost;
        public Node (int time, int cost) {
            this.time = time;
            this.cost = cost;
        }
    }

    static Comparator<Node> cNode = new Comparator<Node>() {
        public int compare(Node o1, Node o2) {
            if (o1.time != o2.time) {
                return o1.time - o2.time;
            }
            return o1.cost - o2.cost;
        }
    };

    public int minMeetingRooms(List<Interval> intervals) {
        // Write your code here
        List<Node> room = new ArrayList<Node>();
        for (int i = 0; i < intervals.size(); i++) {
            room.add(new Node(intervals.get(i).start, 1));
            room.add(new Node(intervals.get(i).end, -1));
        }
        Collections.sort(room, cNode);
        int ans = 0;
        int temp = 0;
        for (int i = 0; i < room.size(); i++) {
            temp += room.get(i).cost;
            ans = Math.max(ans, temp);
        }
        return ans;
    }
}