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
}