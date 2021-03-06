public class LintCode_662 {
    /**
     * @param n an integer
     * @return the number you guess
     */
    public int guessNumber(int n) {
        if (n <= 1) {
            return n;
        }
        int l = 1, r = n;
        while (l <= r) {
            int mid = l + (r - l) / 2;
            int res = guess(mid);
            if (res == 0) {
                return mid;
            } else if (res == -1) {
                r = mid - 1;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
