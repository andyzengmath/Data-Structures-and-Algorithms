public class LintCode_163 {
    /**
     * @param n: An integer
     * @return: An integer
     */
    public int numTrees(int n) {
        // write your code here
        if (n == 0 || n == 1) return 1;
        
        int[] G = new int[n + 1];
        G[0] = 1;
        G[1] = 1;

        for (int i = 2; i <= n; ++i) {
            for (int j = 1; j <= i; ++j) {
                G[i] += G[i - j] * G[j - 1];
            }
        }
        return G[n];
    }
}