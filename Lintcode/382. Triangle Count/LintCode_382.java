public class LintCode_382 {
    /**
     * @param S: A list of integers
     * @return: An integer
     */
    public int triangleCount(int[] S) {
        // write your code here
        int res = 0;
        Arrays.sort(S);
        int n = S.length;
        for (int i = 2; i < n; i++) {
            int k = 0;
            for (int j = i - 1; k < j; j--) {
                while (k < j && S[k] + S[j] <= S[i]) {
                    k++;
                }
                res += j - k;
            }
        }
        return res;
    }
}