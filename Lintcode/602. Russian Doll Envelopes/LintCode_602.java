public class LintCode_602 {
    /**
     * @param envelopes: a number of envelopes with widths and heights
     * @return: the maximum number of envelopes
     */
    public int maxEnvelopes(int[][] envelopes) {
        // write your code here
        int len = envelopes.length;
        if (len < 2) return len;
        Arrays.sort(envelopes, new Comparator<int[]>() {
            @Override
            public int compare(int[] envelope1, int[] envelope2) {
                if (envelope1[0] != envelope2[0]) {
                    return envelope1[0] - envelope2[0];
                }
                return envelope2[1] - envelope1[1];
            }
        });
        
        int[] tail = new int[len];
        tail[0] = envelopes[0][1];
        
        int end = 0;
        for (int i = 1; i < len; i++) {
            int target = envelopes[i][1];
            if (target > tail[end]) {
                end++;
                tail[end] = target;
            } else {
                int left = 0;
                int right = end;
                while (left < right) {
                    int mid = (left + right) >>>1;
                    if (tail[mid] < target) {
                        left = mid + 1;
                    } else {
                        right = mid;
                    }
                }
                tail[left] = target;
            }
        }
        return end + 1;
        
    }


    // better 
    public int maxEnvelopes(int[][] envelopes) {
        if (envelopes == null || envelopes.length == 0) {
            return 0;
        }
        Arrays.sort(envelopes, new Comparator<int[]>(){
            public int compare(int[] arr1, int[] arr2) {
                if (arr1[0] == arr2[0]) {
                    return arr2[1] - arr1[1];
                } else {
                    return arr1[0] - arr2[0];
                }
            }
        });
        
        int n = envelopes.length;
        int[] lis = new int[n + 1];
        lis[0] = Integer.MIN_VALUE;
        for (int i = 1; i <= n; i++) {
            lis[i] = Integer.MAX_VALUE;
        }
        int longest = 0;
        for (int i = 0; i < n; i++) {
            int index = firstGTE(lis, envelopes[i][1]);
            lis[index] = envelopes[i][1];
            longest = Math.max(longest, index);
        }
        return longest;
    }
    
    private int firstGTE(int[] nums, int target) {
        int start = 0, end = nums.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (nums[mid] >= target) {
                end = mid;
            } else {
                start = mid;
            }
        }
        if (nums[start] >= target) {
            return start;
        } else {
            return end;
        }
    }
}