public class LintCode_512 {
    /**
     * @param s: a string,  encoded message
     * @return: an integer, the number of ways decoding
     */
    public int numDecodings(String s) {
        // write your code here
        if (s == null || s.length() == 0) {
            return 0;
        }
        int len = s.length();
        int[] dp = new int[len + 1]; // note can use only 2 value
        dp[len] = 1;
        if (s.charAt(len - 1) == '0') {
            dp[len - 1] = 0;
        } else {
            dp[len - 1] = 1;
        }

        for (int i = len - 2; i >= 0; i--) {
            if (s.charAt(i) == '0') {
                dp[i] = 0;
                continue;
            }
            if ((s.charAt(i) - '0') * 10 + (s.charAt(i + 1) - '0') <= 26) {
                dp[i] = dp[i + 1] + dp[i + 2];
            } else {
                dp[i] = dp[i + 1];
            }
        }
        return dp[0];
        
    }
    // 滚动数组
    public int numDecodings(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        int n = s.length();
        int[] dp = new int[3];
        dp[0] = 1;
        dp[1] = decodeOK(s.substring(0, 1));
        for (int i = 2; i <= n; i++) {
            dp[i % 3] = dp[(i - 1) % 3] * decodeOK(s.substring(i - 1, i)) + dp[(i - 2) % 3] * decodeOK(s.substring(i - 2, i));
        }
        return dp[n % 3];
    }

    private int decodeOK(String substr) {
        int code = Integer.parseInt(substr);
        int len = substr.length();
        if (len == 1 && code >= 1 && code <= 9) {
            return 1;
        }
        if (len == 2 && code >= 10 && code <= 26) {
            return 1;
        }
        return 0;
    }
}