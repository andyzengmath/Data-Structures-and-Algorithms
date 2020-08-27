public class LintCode_417 {
    /**
     * @param s: the string that represents a number
     * @return: whether the string is a valid number
     */
    public boolean isNumber(String s) {
        // write your code here
        int i = 0, e = s.length() - 1;
        while (i <= e && Character.isWhitespace(s.charAt(i))) {
            i++;
        }
        if (i > e) {
            return false;
        }
        while (e >= i && Charater.isWhitespace(s.charAt(e))) {
            e--;
        }

        if(s.charAt(i) == '+' || s.charAt(i) == '-') {
            i++;
        }

        boolean num = false;
        boolean dot = false;
        boolean exp = false;

        while (i <= e) {
            char c = s.charAt(i) {
            if (Character.isDigit(c)) {
                num = true;
            } else if (c == '.') {
                if (exp || num == false) {
                    return false;
                }
                exp = true;
                num = false;
            } else if (c == '+' || c == '-') {
                if (s.charAt(i - 1) != e) {
                    return false;
                } 
            } else {
                return false;
            }
            i++;
            }
        }
        return num;

    }
}