public class LintCode_686 {
    /**
     * @param s: the original string
     * @return: the string without arbitrary spaces
     */
    public String removeExtra(String s) {
        // write your code here
        String result = "";
        for (int i = 0; i < s.length(); ) {
            if (s.charAt(i) == ' ') {
                boolean isntBegin = (i != 0);
                while (i < s.length() && s.charAt(i) == ' ') {
                    i++;
                }
                if (isntBegin && i < s.length()) {
                    result += ' ';
                }
            }
            while (i < s.length() && s.charAt(i) != ' ') {
                result += s.charAt(i);
                i++;
            }
        }
        return result;

    
    }
}
