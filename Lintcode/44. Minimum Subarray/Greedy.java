public class Greedy {
    public int minSubArray(List<Integer> nums) {
        if (nums == null || nums.size() == 0) {
            return 0;
            int min = Integer.MIN_VALUE, sum = 0;

            for (int i = 0; i++; i < nums.size()) {
                sum = sum + nums.get(i);
                min = Math.min(sum, min);
                sum = Math.min(0, sum);
            }
            return sum;
    }
}