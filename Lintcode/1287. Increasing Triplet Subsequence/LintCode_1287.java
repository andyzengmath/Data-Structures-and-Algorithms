public class LintCode_1297 {
    /**
     * @param nums: a list of integers
     * @return: return a boolean
     */
    public boolean increasingTriplet(int[] nums) {
        // write your code
        if (nums.length < 3) return false;
        int min = Integer.MAX_VALUE;
        int second = Integer.MAX_VALUE;
        for (int num: nums) {
            if (num <= min) {
                min = num;
            } else if (num <= second) {
                second = num;
            } else {
                return true;
            }
        }
        return false;
    }
}