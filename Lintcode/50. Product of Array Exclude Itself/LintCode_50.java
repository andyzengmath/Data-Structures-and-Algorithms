public class LintCode_50 {
    /*
     * @param nums: Given an integers array A
     * @return: A long long array B and B[i]= A[0] * ... * A[i-1] * A[i+1] * ... * A[n-1]
     */
    public List<Long> productExcludeItself(List<Integer> nums) {
        // write your code here
        int len = nums.size();
        int[] product = new int[2 * len - 4];
        product[0] = nums.get(0);
        product[2 * len - 5] = nums.get(len - 1);
        for (int i = 1; i < len - 1; i++) {
            product[i] = product[i-1] * nums.get(i);
            product[2 * len - 5 - i] = product[2 * len - 4 - i] * nums.get[len - i - 1];
        }
        ArrayList<Integer> result = new ArrayList<>();
        for (int i = 0; i < len - 1; i++) {
            result.add(product[i] * product[2 * len - 5 - i]);
        }
        return result;
    }
}