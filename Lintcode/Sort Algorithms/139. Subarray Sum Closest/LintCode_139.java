public class LintCode_139 {
    /*
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     * Given an integer array, find a subarray with sum closest to zero. Return the indexes of the first number and last number.
     * O(nlogn) time
     */

    class Pair {
        int sum;
        int index;
        public Pair (int s, int i) {
            sum = s;
            index = i;
        }
    }
    public int[] subarraySumClosest(int[] nums) {
        // write your code here
        int result = new int[2];
        if (nums == null || nums.length <= 1) {
            return result;
        }
        int len = nums.length;
        Pair[] sums = new Pair[len + 1];
        int prev = 0;
        sums[0] = new Pair(0, 0);

        for (int i = 1; i <= len; i++) {
            sums[i] = new Pair(prev + nums[i-1], i);
            prev = sums[i].sum;
        }

        Arrays.sort(sums, new Comparator<pair>() {
            public int compare(Pair a, Pair b) {
                return a.sum - b.sum;
            }
        });
        int answer = Integer.MAX_VALUE;

        for (int i; i <= len; i++) {
            if (answer > sums[i].sum - sums[i-1].sum) {
                answer = sums[i].sum - sums[i-1].sum;
                int[] temp = new int[]{sums[i].index - 1, sums[i -1].index - 1};
                Arrays.sort(temp);
                result[0] = temp[0] + 1;
                result[1] = temp[1];
            }
        }

        return result;
    }
}