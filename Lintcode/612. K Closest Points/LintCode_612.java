/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */

public class LintCode_612 {
    /**
     * @param points: a list of points
     * @param origin: a point
     * @param k: An integer
     * @return: the k closest points
     */
    public Point[] kClosest(Point[] points, Point origin, int k) {
        // write your code here
        PriorityQueue<Point> queue = new PriorityQueue<>(k, (a, b) ->
        {
            int dist = Long.compare(distance(b, origin), distance(a, origin));
            if (dist == 0) {
                dist = b.x - a.x;
            }
            if (dist == 0) {
                dist = b.y - a.y;
            }
            return dist;
        });
        
        for (Point p: points) {
            queue.offer(p);
            if (queue.size() > k) {
                queue.poll();
            }
        }
        k = queue.size();
        Point[] ans = new Point[k];
        while (!queue.isEmpty()) {
            ans[--k] = queue.poll();
        }
        return ans;
    }

    public long distance(Point a, Point b) {
        return (a.x - b.x) * (a.x - b.x) + (a.y - b.y) * (a.y - b.y);
    }
}