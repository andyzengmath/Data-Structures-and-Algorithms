/**
 * Definition for a point.
 * class Point {
 *     int x;
 *     int y;
 *     Point() { x = 0; y = 0; }
 *     Point(int a, int b) { x = a; y = b; }
 * }
 */
public class LintCode_626 {
     /**
     * @param l1: top-left coordinate of first rectangle
     * @param r1: bottom-right coordinate of first rectangle
     * @param l2: top-left coordinate of second rectangle
     * @param r2: bottom-right coordinate of second rectangle
     * @return: true if they are overlap or false
     */
    public boolean doOverlap(Point l1, Point r1, Point l2, Point r2) {
        // write your code here
        if (intersection(l1.x, r1.x, l2.x, r2.x) && intersection(r1.y, l1.y, r2.y, l2.y)) return true;
        return false;
    }

    public boolean intersection(int x1, int y1, int x2, int y2) {
        return Math.max(x1, x2) <= Math.min(y1, y2);
    }
}