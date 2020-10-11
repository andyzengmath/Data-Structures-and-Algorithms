public class LintCode_400 {
    /** Leet 164
     * @param nums: an array of integers
     * @return: the maximun difference
     */
    public int maximumGap(int[] nums) {
        // write your code here
        if (nums == null || nums.length < 2) return 0;
        int min = nums[0];
        int max = nums[0];
        for (int i: nums) {
            min = Math.min(i, min);
            max = Math.max(i, max);
        }       
        
        int gap = (int)Math.ceil((double)(max - min)/(nums.length - 1));
        int[] bucketsMin = new int[nums.length - 1];
        int[] bucketsMax = new int[nums.length - 1];
        Arrays.fill(bucketsMin, Integer.MAX_VALUE);
        Arrays.fill(bucketsMax, Integer.MIN_VALUE);

        for (int i: nums) {
            if (i == min || i == max) continue;
            int idx = (i - min) / gap;
            bucketsMin[idx] = Math.min(i, bucketsMin[idx]);
            bucketsMax[idx] = Math.max(i, bucketsMax[idx]);
        }

        int maxGap = Integer.MIN_VALUE;
        int previous = min;
        for (int i = 0; i < nums.length - 1; i++) {
            if (bucketsMin[i] == Integer.MAX_VALUE && bucketsMax[i] == Integer.MIN_VALUE) {
                continue;
            }
            maxGap = Math.max(maxGap, bucketsMin[i] - previous);
            previous = bucketsMax[i];
        }
        maxGap = Math.max(maxGap, max - previous);
        return maxGap;
    }
}