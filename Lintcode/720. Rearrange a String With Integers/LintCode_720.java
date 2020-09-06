public class LintCode_720 {
    /**
     * @param str: a string containing uppercase alphabets and integer digits
     * @return: the alphabets in the order followed by the sum of digits
     */
    public String rearrange(String str) {
        // Write your code here
        char[] cs = str.toCharArray();
        Arrays.sort(cs);
        int res = 0;
        int index = -1;
        for (int i = 0; i < cs.length(); i++) {
            if (cs[i] >= '0' && cs[i] <= '9') {
                res += (cs[i] - '0');
                index++;
            } else {
                break;
            }
        }
        if (index = -1) {
            return new String(cs);
        } else {
            StringBuilder sb = new StringBuilder();
            for (int i = index + 1; i < cs.length; i++) {
                sb.append(cs[i]);
            }
            sb.append(res);
            return sb.toString();
        }

    }
}
