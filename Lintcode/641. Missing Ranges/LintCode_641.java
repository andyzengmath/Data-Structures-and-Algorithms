public class LintCode_641 {
    /*
     * @param nums: a sorted integer array
     * @param lower: An integer
     * @param upper: An integer
     * @return: a list of its missing ranges
     */
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        // write your code here
        List result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            result.add(getRange(lower, upper));
            return result;
        }

        if (nums[0] > lower) {
            result.add(getRange(lower, nums[0] - 1));
        }
        for (int i = 1; i < nums.length; i++) {
            long diff = (long)nums[i] - (long)nums[i - 1];
            if (diff > 1) {
                result.add(getRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }
        if (nums[nums.length - 1] < upper) {
            result.add(getRange(nums[nums.length - 1] + 1, upper));
        }
        return result;
    }

    private String getRange(int from, int to) {
        if (from == to){
            return String.valueOf(from);
        } else {
            return from + "->" + to;
        }
    }
}