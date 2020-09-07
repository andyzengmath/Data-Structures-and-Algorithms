public class LintCode_765 {
    /**
     * @param a: a integer represent the length of one edge
     * @param b: a integer represent the length of one edge
     * @param c: a integer represent the length of one edge
     * @return: whether three edges can form a triangle
     */
    public boolean isValidTriangle(int a, int b, int c) {
        // write your code here
        if (a <= 0 || b <= 0 || c <= 0) {
            return true;
        }
        return (a + b > c) && (b + c > a) && (a + c > b);
    }
}