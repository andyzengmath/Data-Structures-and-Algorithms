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
            while (nums % i == 0) {
                results.add(i);
                nums /= i;
            }
        }
        if (nums > 1) {
            results.add(nums);
        }
        return results;
    }
}