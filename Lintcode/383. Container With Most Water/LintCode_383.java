public class LintCode_383 {
    /**
     * @param heights: a vector of integers
     * @return: an integer
     */
    public int maxArea(int[] heights) {
        // two pointer
        int max = 0, l = 0, r = heights.length - 1;
        while (l < r) {
            max = Math.max(max, Math.min(heights[l], heights[r]) * (r - l));
            if (heights[l] < heights[r]) {
                l++;
            } else {
                r--;
            }
        }
        return max;

    }
}