public class LintCode_1352 {
    /** LeetCode 165
     * @param version1: the first given number
     * @param version2: the second given number
     * @return: the result of comparing
     */
    public int compareVersion(String version1, String version2) {
        // Write your code here
        String[] nums1 = version1.split("\\.");
        String[] nums2 = version2.split("\\.");
        int i1, i2;
        for (int i = 0; i < Math.max(nums1.length, nums2.length); i++) {
            i1 = i < nums1.length ? Integer.parseInt(nums1[i]) : 0;
            i2 = i < nums2.length ? Integer.parseInt(nums2[i]) : 0;
            if (i1 != i2) {
                return i1 > i2 ? 1 : -1;
            }
        }
        return 0;
    }
}