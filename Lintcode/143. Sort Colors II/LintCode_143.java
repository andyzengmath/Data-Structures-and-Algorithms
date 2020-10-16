public class LintCode_143 {
    /**
     * @param colors: A list of integer
     * @param k: An integer
     * @return: nothing
     * A rather straight forward solution is a two-pass algorithm using counting sort. That will cost O(k) extra memory. Can you do it without using extra memory?
     */
    public void sortColors2(int[] colors, int k) {
        // write your code here
        // quicksort
        if (colors == null || colors.length <= 1 || k <=1) {
            return;
        }
        sort(colors, 0, colors.length - 1, 1, k);
    }

    private void sort(int[] colors, int start, int end, int colorStart, int colorEnd) {
        if (start >= end || colorStart == colorEnd) {
            return;
        }

        int left = start, right = end;
        int mid = (colorStart + colorEnd) / 2;

        while (left <= right) {
            while (left <=right && colors[left] <= mid) {
                left ++;
            }
            while (left <= right && colors[right] > mid) {
                right --;
            }
            if (left <= right) {
                int temp = colors[left];
                colors[left] = colors[right];
                colors[right] = temp;
            } 
        }

        sort(colors, start, right, colorStart, mid);
        sort(colors, left, end, mid + 1, colorEnd);
    }
}