public class LintCode_362 {
    /**
     * @param nums: A list of integers.
     * @param k: An integer
     * @return: The maximum number inside the window at each moving.
     */
    public List<Integer> maxSlidingWindow(int[] nums, int k) {
        // write your code here
        if (nums == null || k <= 0) return new ArrayList<>();
        List<Integer> res = new ArrayList<>();
        int index = 0;
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < nums.length; i++) {
            if (!queue.isEmpty() && queue.peekFirst() <= i - k) {
                queue.pollFirst();
            }
            while (!queue.isEmpty() && nums[queue.peekLast()] < nums[i]) {
                queue.pollLast();
            }
            queue.addLast(i);
            if (i >= k - 1) {
                res.add(nums[queue.peekFirst()]);
            }
        }
        return res;
    }
}