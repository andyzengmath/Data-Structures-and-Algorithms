public class LintCode_685 {
    /**
     * @param nums: a continuous stream of numbers
     * @param number: a number
     * @return: returns the first unique number
     */
    public int firstUniqueNumber(int[] nums, int number) {
        // Write your code here
        Map<Integer, Integer> counter = new HashMap<>();

        boolean isBreak = false;
        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (!counter.containsKey(num)) {
                counter.put(num, 1);
            } else {
                counter.put(num, counter.get(num) + 1);
            }
            if (num == number) {
                isBreak = true;
                break;
            }
        }
        if (!isBreak) {
            return -1;
        }

        for (int i = 0; i < nums.length; i++) {
            int num = nums[i];
            if (counter.get(num) == 1) {
                return num;
            }
            if (num == number) {
                break;
            }     
        }
        return -1;
    }
}