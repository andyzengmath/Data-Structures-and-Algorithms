public class LintCode_78 {
    /** LeetCode-13
     * @param strs: A list of strings
     * @return: The longest common prefix
     * Time complexity : O(S), where S is the sum of all characters in all strings.
     * space O(1)
     */
    public String longestCommonPrefix(String[] strs) {
        // write your code here
        if (strs.length == 0) return "";
        String prefix = strs[0];
        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(prefix) != 0) {
                prefix = prefix.substring(0, prefix.length() - 1);
                if (prefix.isEmpty()) return "";
            }
        }
        return prefix;
    }
}