public class LintCode_784 {
    /**
     * @param dic: the n strings
     * @param target: the target string
     * @return: The ans
     * The sum of the length of n strings is sum, 1 <= sum <= 50000. 
     * The length of each string is greater than 0(i.e. there is no empty string).
     */
    public int the_longest_common_prefix(List<String> dic, String target) {
        // write your code here
        int max = 0;
        for (String item: dic) {
            int same = 0;
            for (int i = 0; i < target.length(); i++) {
                if (i >= item.length()|| target.charAt(i) != item.charAt(i)) {
                    break;
                }
                same++;
            }
            max = Math.max(same, max);
        }
        return max;
    }
}