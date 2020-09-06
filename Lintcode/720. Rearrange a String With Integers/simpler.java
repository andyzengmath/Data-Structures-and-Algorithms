public class simpler {
    public String rearrange(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int n = s.length(), sum = 0;
        char[] ss = s.toCharArray();
        Arrays.sort(ss);
        StringBuilder sb = new StringBuilder();
        for (int 0; i < n; i++) {
            if (Character.isDigit(ss[i])) {
                sum += ss[i] - '0';
            } else {
                sb.append(ss[i]);
            }
        }
        sb.append(sum);
        return sb.toString();
    }
}
