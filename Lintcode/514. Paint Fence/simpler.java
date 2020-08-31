public class simpler {
    public int numWays(int n, int k) {
        int same = 0, diff = k;
        for (int i = 1; i < n; i++) {
            int tmp = diff;
            diff = (diff + same) * (k - 1);
            same = tmp;
        }
        return same + diff;
    }
}