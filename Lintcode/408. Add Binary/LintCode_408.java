public class LintCode_408 {
    /**
     * @param a: a number
     * @param b: a number
     * @return: the result
     */
    public String addBinary(String a, String b) {
        // write your code here
        if (a.length() < b.length()) {
            String temp = a;
            a = b;
            b = temp;
        }
        int len1 = a.length() - 1;
        int len2 = b.length() - 1;
        int add = 0;
        String result = "";

        while (len2 >= 0) {
            int sum = (int)(a.charAt(len1) - '0') + (int)(b.charAt(len2) - '0') + add;
            result = String.valueOf(sum % 2) + result;
            add = sum / 2;
            len1--;
            len2--;
        }

        while (len1 >= 0) {
            int sum = (int)(a.charAt(len1) - '0') + add;
            result = String.valueOf(sum % 2) + result;
            add = sum / 2;
            len1--;
        }

        if (add == 1) {
            result = "1" + result;
        }
        return result;
    }
}