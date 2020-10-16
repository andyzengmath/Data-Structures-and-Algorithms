public class LintCode_644 {
    /**
     * @param num: a string
     * @return: true if a number is strobogrammatic or false
     */
    public boolean isStrobogrammatic(String num) {
        if (num == null || num.length() == 0) {
            return false;
        }

        int left = 0;
        int right = num.length() - 1;
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);

            if (left == right) {
                if (leftChar == '0' || leftChar == '1'|| leftChar == '8') {
                    return true;
                } else {
                    return false;
                }
            } else {
                if (leftChar == rightChar) {
                    if (leftChar == '0' || leftChar == '1' || leftChar == '8') {
                        left++;
                        right--;
                    } 
                } else if ((leftChar == '6' && rightChar == '9')||(leftChar == '9' && rightChar == '6')) {
                    left++;
                    right--;
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}