public class LintCode_48 {
    /**
     * @param nums: A list of integers
     * @param k: An integer
     * @return: The majority number
     */
    public int majorityNumber(List<Integer> nums, int k) {
        // write your code here
        int size = nums.size() / k;
        Map<Integer, Integer> map = new HashMap<>();

        for (int num: nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        for (Integer num: map.keySet()) {
            if (map.get(num) > size) {
                return num;
            }
        }
        return -1;
    }
}