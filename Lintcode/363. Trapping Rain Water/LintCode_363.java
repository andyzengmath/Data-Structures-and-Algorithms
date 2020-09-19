public class LintCode_363 {
    /** Leet 42
     * O(n) O(n)
     * O(1) space using 
     * @param heights: a list of integers
     * @return: a integer
     */
    public int trapRainWater(int[] heights) {
        int sum = 0;
        int[] max_left = new int[heights.length];
        int[] max_right = new int[heights.length];

        for (int i = 1; i < heights.length - 1; i++) {
            max_left[i] = Math.max(max_left[i - 1], heights[i - 1]);
        }
        for (int j = heights.length - 2; j >= 0; j--) {
            max_right[j] = Math.max(max_right[j + 1], heights[j + 1]);
        }
        for (int k = 1; k < heights.length - 1; k++) {
            int min = Math.min(max_left[k], max_right[k]);
            if (min > heights[k]) {
                sum += (min - heights[k]);
            }
        }
        return sum;
    }
}