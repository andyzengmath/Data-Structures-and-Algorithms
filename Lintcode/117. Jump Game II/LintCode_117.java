public class LintCode_117 {
    /** leet 45
     * @param A: A list of integers
     * @return: An integer
     */
    public int jump(int[] nums) {
        // write your code here
        int len = nums.length;
        int step = 1;
        if (len <= 1) return 0;
        int index = 0; // starting point for each jump
        int max = nums[0]; // maximum 
        while (max < len - 1) {
            int curMax = 0;
            for (int i = index + 1; i <= max; i++) {
                if (i + nums[i] > curMax) {
                    curMax = i + nums[i];
                    index = i;
                }
            }
            max = index + nums[index];
            step++;
        }
        return step;
    }
}