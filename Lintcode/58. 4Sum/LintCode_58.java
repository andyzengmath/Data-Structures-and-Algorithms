public class LintCode_58 {
    /**
     * @param numbers: Give an array
     * @param target: An integer
     * @return: Find all unique quadruplets in the array which gives the sum of zero
     */
    public List<List<Integer>> fourSum(int[] numbers, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length < 4) {
            return result;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 3; i++) {
            if (i > 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            for (int j = i + 1; j < numbers.length - 2; j++) {
                if (j > i + 1 && numbers[j] == numbers[j - 1]) {
                    continue;
                }
                int left = j + 1, right = numbers.length - 1;
                int target1 = target - numbers[i] - numbers[j];

                while (left < right) {
                    if (numbers[left] + numbers[right] == target1) {
                        List<Integer> list = new ArrayList<>();
                        list.add(numbers[i]);
                        list.add(numbers[j]);
                        list.add(numbers[left]);
                        list.add(numbers[right]);
                        result.add(list);
                        
                        right--;
                        left++;
                        
                        while (right > left && numbers[right] == numbers[right + 1]) {
                            right--;
                        }

                        while (left < right && numbers[left] == numbers[left - 1]) {
                            left++;
                        }
                    } else if (numbers[left] + numbers[right] > target1) {
                        right--;
                        while (right > left && numbers[right] == numbers[right + 1]) {
                            right--;
                        }
                    } else if (numbers[left] + numbers[right] < target1) {
                        left++;
                        while (left < right && numbers[left] == numbers[left - 1]) {
                            left++;
                        }
                    }
                }
            }
        }
        return result;
    }
}