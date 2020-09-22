public class combinatorial {
    public int uniquePaths(int m, int n) {
        if (m == 0 || n == 0) {
            return 0;
        } else if (m == 1 || n == 1) {
            return 1;
        }

        if (m > n) {
            int temp = n;
            n = m;
            m = temp;
        }

        double temp = 1;
        double result = 1;
        for (int i = 1; i <= m - 1; i++) {
            temp *= i;
        }
        for (int j = n; j <= m + n - 2, j++) {
            result *= j;
        }
        result = result / temp;
        return (int)Math.round(result);
    }
}