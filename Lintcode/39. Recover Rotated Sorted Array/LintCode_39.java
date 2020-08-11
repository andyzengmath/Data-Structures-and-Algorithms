public class LintCode_39 {
    /**
     * @param nums: An integer array
     * @return: nothing
     * In-place, O(1) extra space and O(n) time.
     */
    public void recoverRotatedSortedArray(List<Integer> nums) {
        // write your code here
        int cur = 0;
        int len = nums.size() - 1;
        while (cur < len) {
            if (nums.get(cur) <= nums.get(cur + 1)) {
                cur ++;
            } else {
                break;
            }
        }

        if (cur == len) {
            return;
        }

        for (int i = cur + 1; i < len; i ++) {
            int val = nums.get(i);
            nums.remove(i);
            nums.add(i - cur - 1, val);
        }
    }
}