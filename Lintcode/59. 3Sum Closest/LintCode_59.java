public class LintCode_59 {
    /** LeetCode-16
     * https://en.wikipedia.org/wiki/3SUM
     * @param numbers: Give an array numbers of n integer
     * @param target: An integer
     * @return: return the sum of the three integers, the sum closest target.
     * Challenge: O(n^2) time, O(1) extra space
     */
    public int threeSumClosest(int[] numbers, int target) {
        
        int closest = Integer.MAX_VALUE;
        Arrays.sort(numbers);
        for (int i = 0; i < numbers.length - 2; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1, right = numbers.length - 1;
            while (left < right) {
                int curr = numbers[i] + numbers[left] + numbers[right];

                if (curr == target) {
                    return target;
                }
                if (Math.abs(curr - target) < Math.abs(closest - target)) {
                    closest = curr;
                }
                if (curr > target) {
                    right -= 1;
                    while (left < right && numbers[right] == numbers[right + 1]) {
                        right -= 1;
                    }
                } else {
                    left += 1;
                    while (left < right && numbers[left] == numbers[left - 1]) {
                        left += 1;
                    }
                }
            }
        }

        return closest;

    }
}