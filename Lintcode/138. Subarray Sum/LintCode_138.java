import java.util.Map;

public class LintCode_138 {
    /**
     * @param nums: A list of integers
     * @return: A list of integers includes the index of the first number and the index of the last number
     */
    public List<Integer> subarraySum(int[] nums) {
        // write your code here
        List<Integer> result = new ArrayList<>();

        Map<Integer, Integer> sumMap = new HashMap<>();
        sumMap.put(0, -1);
        int sum = 0;

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sumMap.containsKey(sum)) {
                result.add(sumMap.get(sum) + 1);
                result.add(i);
                break;
            }
            sumMap.put(sum, i);
        }
        return result;
    }
}