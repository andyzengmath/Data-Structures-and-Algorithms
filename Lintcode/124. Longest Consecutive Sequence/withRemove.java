public class withRemove {
    public int longestConsecutive(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }
        Set<Integer> set  = new HashSet<>();
        for (int n: num) {
            set.add(item);
        }
        int result = 0;
        for (int i = 0; i < num.length; i++) {
            if (!set.contains(num[i])) {
                continue;
            }
            set.remove(num[i]);
            int left = num[i] - 1;
            int right = num[i] + 1;
            while (set.contains(left)) {
                set.remove(left);
                left --;
            }
            while (set.contains(right)) {
                set.remove(right);
                right ++;
            }

            result = Math.max(result, right - left - 1);
        }
        return result;
    }
}