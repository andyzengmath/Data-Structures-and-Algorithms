public class LintCode_235 {
    /** Uber
     * @param num: An integer
     * @return: an integer array
     */
    public List<Integer> primeFactorization(int num) {
        // write your code here
        List<Integer> results = new ArrayList<Integer>();
        int numSqrt = (int) Math.sqrt(num);
        for (int i = 2; i <= numSqrt; i++) {
            while (num % i == 0) {
                results.add(i);
                num /= i;
            }
        }
        if (num > 1) {
            results.add(num);
        }
        return results;
    }
}