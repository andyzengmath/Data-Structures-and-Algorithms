public class LintCode_1300 {
    /**
     * @param n: an integer
     * @return: whether you can win the game given the number of stones in the heap
     */

     // memoization search: stackoverflow
    public boolean canWinBash(int n) {
        // Write your code here
        return memoSearch(n, new HashMap<>());
    }

    private boolean memoSearch(int n, Map<Integer, Boolean> memo) {
        if (n <= 3) return true;

        if (memo.containsKey(n)) {
            return memo.get(n);
        }

        for (int i = 1; i <= 3; i++) {
            if (!memoSearch(n - i, memo)) {
                memo.put(n, true);
                return true;
            }
        }
        return false;
    }
}

// dp: time exceeded
public boolean canWinBash(int n) {
    // Write your code here
    if (n <= 3) return true;
    
    boolean[] dp = new boolean[3];
    for (int i = 0; i <= 2; i++) {
        dp[i] = true;
    }
    for (int i = 3; i < n; i++) {
        dp[i % 3] = !dp[(i - 1) % 3] || !dp[(i -2) % 3] || !dp[(i - 3) % 3];
    }
    return dp[(n - 1) % 3];
}

public boolean canWinBash(int n) {
    // Write your code here
    if (n % 4 == 0) {
        return false;
    } else {
        return true;
    }
}