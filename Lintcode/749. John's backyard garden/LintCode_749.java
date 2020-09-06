public class LintCode_749 {
    /**
     * @param x: the wall's height
     * @return: YES or NO
     * X is an integer, and it's range is [3, 1000].
     */
    public String isBuild(int x) {
        // write you code here
        boolean[] f = new boolean[x + 1];
        f[0] = true;
        int[] w = new int[]{3, 7};
        for (int i = 0; i < 2; i++) {
            for (int j = w[i]; j <= x; j++) {
                f[j] = f[j] || f[j - w[i]];
            }
        }
        return f[x] ? "YES": "NO";
    }
}