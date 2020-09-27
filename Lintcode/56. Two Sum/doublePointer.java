public class doublePointer {
    public int[] twoSum(int[] numbers, int target) {
        int[] backup = new int[numbers.length];
        System.arraycopy(numbers, 0, backup, 0, numbers.length);
        Arrays.sort(numbers);
        int i = 0, j = numbers.length - 1;
        
        while (i < j) {
            if (numbers[i] + numbers[j] == target) {
                break;
            } else if (numbers[i] + numbers[j] < target) {
                i += 1;
            } else {
                j -= 1;
            }
        }
        int a = 0, b = 0;
        for (int k = 0; k < numbers.length; k++) {
            if (backup[k] == numbers[i] && a == 0) {
                i = k;
                a = 1;
            } else if (backup[k] == numbers[j] && b == 0) {
                j = k;
                b = 1;
            } else if (a == 1 & b == 1) {
                break;
            }
            
        }
        int[] result = new int[]{i, j};
        Arrays.sort(result);
        return result;
    }
}