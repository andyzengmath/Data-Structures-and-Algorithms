public class LintCode_272 {
    /**
     * @param n: An integer
     * @return: An Integer
     */
    public int climbStairs2(int n) {
        // write your code here
        if (n == 0 || n == 1) {
            return 1;
        }
        int[] list = new int[n+1];
        list[0] = 1;
        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= 3; j++) {
                if (i >= j) {
                    list[i] += list[i - j];
                }
            }
        }
        return list[n];
    }
}