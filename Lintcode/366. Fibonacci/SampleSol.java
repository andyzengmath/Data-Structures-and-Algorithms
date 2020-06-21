public class SampleSol {
// time complexity: O(n)
// space complexity: O(n)

    int dfs(int n, int[] fib){
        if (fib[n] != -1) {
            return fib[n];
        }
        if (n <= 2) {
            fib[n] = n - 1;
            return fib[n];
        }
        return fib[n];
    }
    public int fibonacci(int n){
        int[] result = new int[n + 1];
        for (int i = 0; i < n - 1; i++) {
            result[i] = -1;
        }
        dfs(n, result);

        return result[n];

    }
    
}