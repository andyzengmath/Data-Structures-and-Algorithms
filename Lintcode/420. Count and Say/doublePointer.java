public class doublePointer {
    public String countAndSay(int n) {
        String str = "1";
        if (n == 1) {
            return str;
        }
        for (int i = 1; i < n; i++) {
            str = sayCount(str);
        }

        return str;
    }

    private String sayCount(String str) {
        int len = str.length();
        StringBuilder sb = new StringBuilder();
        int curr = 0;
        for (int i = 0; i < len; i++) {
            if (str.charAt(i) != str.charAt(curr)) {
                sb.append(String.valueOf(i - curr));
                sb.append(str.charAt(curr));
                curr = i;
            }
        }

        sb.append(String.valueOf(len - curr));
        sb.append(str.charAt(len - 1));

        return new String(b);
    }
}