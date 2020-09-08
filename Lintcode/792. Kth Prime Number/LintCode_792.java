public class LintCode_792 {
    /**
     * @param n: the number
     * @return: the rank of the number
     */
    public int kthPrime(int n) {
        // write your code here
        boolean[] prime = new boolean[100009];
        for (int i = 2; i < n; i++) {
            prime[i] = false;
        }
        for (int i = 2; i < n; i++) {
            if (prime[i] == false) {
                for (int j = 2 * i; j < n; j += i) {
                    prime[j] = true;
                }
            }
        }
        int num = 1;
        for (int i = 2; i < n; i++) {
            if (prime[i] == false) {
                num++;
            }
        }

        return num;
    }
}