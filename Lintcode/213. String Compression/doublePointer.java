public class doublePointer {
    public String compress(String os) {
        if (os == null || os.length() <= 2) {
            return os;
        }

        int start = 0;
        int end = 1;
        StringBuilder sb = new StringBuilder();
        while (end < os.length()) {
            while (end < os.length() && os.charAt(end) == os.charAt(end - 1)) {
                end ++;
            }
            sb.append(os.charAt(start) + "" + (end - start));
            start = end;
            end++;
        }

        String result = sb.toString();

        return (res.length() < os.length()) ? result : os;
    }
}