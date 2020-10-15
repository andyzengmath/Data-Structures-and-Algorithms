class LeetCode_1047 {
    public String removeDuplicates(String S) {
        StringBuilder sb = new StringBuilder();
        int len = 0;
        for (char character: S.toCharArray()) {
            if (sb.length() !=  0 && character == sb.charAt(len - 1)) {
                sb.deleteCharAt(len-- - 1);
            } else {
                sb.append(character);
                len++;
            }
        }
        return sb.toString();
    }
}