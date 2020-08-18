public class LintCode_141 {
    /**
     * @param x: An integer
     * @return: The sqrt of x
     */
    public int sqrt(int x) {
        // write your code here
        // first try: binary search
        if (x < 0) throw new IllegalArgumentException();
        else if (x <= 1) {
            return x;
        }
        int start = 1, end = x;
        while (start + 1 < end) {
            int mid = (start + end) / 2;
            if (mid == x / mid) {
                return mid; // note: mid * mid = x might cause overflow
            } else if (mid < x / mid) {
                start = mid;
            } else {
                end = mid;
            }

        }
        if (end > x / end) {
            return start;
        }
        return end;
    }
}