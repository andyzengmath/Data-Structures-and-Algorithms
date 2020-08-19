public class LintCode_157 {
    /*
     * @param str: A string
     * @return: a boolean
     * What if you can not use additional data structures?
     */
    public boolean isUnique(String str) {
        // write your code here
        int len = str.length();
        if (len == 0 || len == 1) {
            return true;
        }
        for (int i = 0; i < len - 1; i++) {
            for (int j = i + 1; j < len; j++) {
                if (str.charAt(i) == str.charAt(j)) {
                    return false;
                }
            }
        }
        return true;
    }
}