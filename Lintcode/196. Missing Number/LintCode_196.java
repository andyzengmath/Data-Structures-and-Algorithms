public class LintCode_196 {
    /**
     * @param nums: An array of integers
     * @return: An integer
     */
    // bit
    public int findMissing(int[] nums) {
        // write your code here
        int missing = nums.length;
        for (int i = 0; i < nums.length; i++) {
            missing ^= i ^ nums[i];
        }
        return missing;
    }

    // math
    public int findMissing(int[] nums) {
        // write your code here
        int expect = nums.length * (nums.length + 1) / 2;
        for (int num: nums) {
            expect -= num;
        }
        return expect;
    }
}