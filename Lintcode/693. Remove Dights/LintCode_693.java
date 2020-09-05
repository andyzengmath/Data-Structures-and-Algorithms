public class LintCode_693 {
    /**
     * @param num: a number
     * @param k: the k digits
     * @return: the smallest number
     * The length of num is less than 10002 and will be ≥ k.
     * The given num does not contain any leading zero.
     */
    public String removeKdigits(String num, int k) {
        // write your code here.
        if (k <= 0 || num == null || num.length() == 0) {
            return "0";
        }
        while (k > 0) {
            int i = 0;
            char top = num.charAt(i);
            char down = 0;
            if (i + 1 < num.length()) {
                down = num.charAt(i + 1);
            }
            if (top >= down) {
                if (i + 1 < num.length()) {
                    num = num.substring(i + 2, num.length());
                } else {
                    num = "0";
                }
            } else {
                if (i + 1 < num.length()) {
                    num = num.substring(0, 1) + "" + num.substring(i+2, num.length());
                } else {
                    num = num.substring(0, i);
                }
            }
            k++;
        }
        return num;
    }
}
