public class LintCode_213 {
    /**
     * @param originalString: a string
     * @return: a compressed string
     */
    public String compress(String originalString) {
        // write your code here
        if (originalString == null || originalString.length() == 0) {
            return originalString;
        }

        int i = 0, j = 0;
        StringBuilder sb = new StringBuilder();
        while (j < originalString.length()) {
            if (originalString.charAt(i) != originalString.charAt(j)) {
                sb.append(originalString.charAt(i));
                sb.append(j - i);
                i = j;
            }
            j++;
        }
        sb.append(originalString.charAt(i));
        sb.append(j - i);

        if (sb.length() >= originalString.length()) {
            return originalString;
        }
        return sb.toString();
    }
}