public class LintCode_1536 {
    /**
     * @param nums: the array of integers
     * @param target: 
     * @return: the starting and ending position
     */
    public List<Integer> searchRange(List<Integer> nums, int target) {
        // not pass!!

        int left = 0, right = nums.size() - 1;
        while (left <= right) {
            int mid = (left + right) / 2;
            if (nums.get(mid) >= target) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        if (left == nums.size() || nums.get(right) != right) {
            return Arrays.asList(-1,-1);
        } else {
            int i = 0;
            while (i <= nums.size() - 1 - right) {
                if (nums.get(right + 1 + i) == target) {
                    i += 1;
                }
            }
            return Arrays.asList(right, right + i);
        }

    }
}