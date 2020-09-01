public class LintCode_547 {
    /**
     * @param nums1: an integer array
     * @param nums2: an integer array
     * @return: an integer array
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        // write your code here
        // time complexity O(m + n) space O(max(n, m)) 
        HashSet<Integer> set1 = new HashSet<Integer>();
        for (int num: nums1) {
            set1.add(num);
        }

        HashSet<Integer> set2 = new HashSet<Integer>();
        for (int num: nums2) {
            if (set1.contains(num)) {
                set2.add(num);
            }
        }
        int[] result = new int[set2.size()];
        int index = 0;
        for (int num: set2) {
            result[index++] = num;
        }

        return result;
    }
}