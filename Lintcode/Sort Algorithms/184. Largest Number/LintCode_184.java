public class LintCode_184 {
    /**
     * @param nums: A list of non negative integers
     * @return: A string
     * Do it in O(nlogn) time complexity.
     */
    class cmp implements Comparator<String> {
        public int compare(String a, String b) {
            String ab = a.concat(b);
            String ba = b.concat(a);
            return ba.compareTo(ab);
        }
    }

    public String largestNumber(int[] nums) {
        // write your code here
        int n = nums.length;
        String[] str new String[n];
        for (int i = 0; i < n; i++) {
            str[i] = String.valueOf(nums[i]);
        }

        Arrays.sort(str, new cmp());
        String ans = "";
        for (int i = 0; i < n; i++) {
            ans = ans.concat(str[i]);
        }
        if (ans.charAt(0) == '0') {
            return "0";
        }

        return ans;
    }
}