public class LintCode_437 {
    /** O(nk) time


     * @param pages: an array of integers
     * @param k: An integer
     * @return: an integer
     */
    public int copyBooks(int[] pages, int k) {
        // write your code here
        if (pages == null || pages.length == 0) {
            return 0;
        }
        if (k == 0) return -1;
        
        int start = 0, end = Integer.MAX_VALUE;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (getNumberOfCopiers(pages, mid) <= k) {
                end = mid;
            } else {
                start = mid;
            }
        }
        
        if (getNumberOfCopiers(pages, start) <= k) {
            return start;
        }
        return end;
    }
    
    // limit is the time limit
    private int getNumberOfCopiers(int[] pages, int limit) {
        int copiers = 0;
        int lastCopied = limit;
        for (int page: pages) {
            if (page > limit) {
                return Integer.MAX_VALUE;
            }
            if (lastCopied + page > limit) {
                copiers++;
                lastCopied = 0;
            }
            
            lastCopied += page;
        }
        return copiers;
    }


    // dp 
    public int copyBooks(int[] pages, int k) {
        if (pages == null || pages.length == 0 || k == 0) {
            return 0;
        }
        
        int n = pages.length;
        int[] prefixSum = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            prefixSum[i] = prefixSum[i - 1] + pages[i - 1];
        }
        int[][] dp = new int[n + 1][k + 1];

        for (int i = 1; i <= n; i++) {
            dp[i][0] = Integer.MAX_VALUE;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = Integer.MAX_VALUE;
                for (int prev = 0; prev < i; prev++) {
                    int cost = prefixSum[i] - prefixSum[prev];
                    dp[i][j] = Math.min(dp[i][j], Math.max(dp[prev][j - 1], cost));
                }
            }
        }

        return dp[n][k];
    }
}