public class LintCode_366 {
    /** can't pass leet
     * @param n: an integer
     * @return: an integer f(n)
     */
    public int fibonacci(int n) {
        // time complexity: O(n)
        // space complexity: O(1)
        int first = 0;
        int second = 1;

        if (n == 1) {
            return 0;
        } else if (n == 2) {
            return 1;
        } else {
            for (int i = 0; i < n-2; i++){
                int current = first + second;
                first = second;
                second = current;
            }
        }
        return second;

    }
}