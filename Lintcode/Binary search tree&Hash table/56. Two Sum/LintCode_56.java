public class LintCode_56 {
    /**
     * @param numbers: An array of Integer
     * @param target: target = numbers[index1] + numbers[index2]
     * @return: [index1 + 1, index2 + 1] (index1 < index2)
     * Challenge: O(n) Space, O(nlogn) Time
     * or O(n) Space, O(n) Time
     */
    public int[] twoSum(int[] numbers, int target) {
        // write your code here】
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        int[] result = {0, 0};
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) != null){
                int[] result = {map.get(numbers[i]), i};
                return result;
            }
            map.put(target - numbers[i], i);
        }
        return result;
    }
}