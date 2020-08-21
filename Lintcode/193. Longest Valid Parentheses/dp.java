public class dp {
    public int longestValidParentheses(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[n];
        char[] sc = s.toCharArray();
        dp[0] = 0;
        int result = 0;
        for (int i = 1; i < n; i++) {
            dp[i] = 0;
            if (sc[i] == ')') {
                if (sc[i-1] == '(') {
                    f[i] = 2;
                    if (f[i - 2] >= 0) {
                        f[i] += f[i - 2];
                    }
                } else {
                    if (f[i - 1] > 0) {
                        if (i - 1 - f[i - 1] >= 0 && sc[i - 1 - f[i - 1]] == '(') {
                            f[i] = f[i - 1] + 2;
                            if (i >= f[i] && f[i - f[i]] > 0) {
                                f[i] += f[i - f[i]];
                            }
                        }
                    }
                }
            }
            result = Math.max(result, f[i]);
        }
        return result;
    }
}