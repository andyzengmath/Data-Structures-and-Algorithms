public class LintCode_188 {
    /**
     * @param a: A number
     * @return: Returns the maximum number after insertion
     */
    public int InsertFive(int a) {
        // write your code here
        String num = String.valueOf(a);
        int i = 0;
        if (a >= 0) {
            while (i < num.length() && num.charAt(i) > '5') {
                i++;
            }
        } else {
            i = 1;
            while (i < num.length() && num.charAt(i) < '5') {
                i++;
            }
        }

        return Integer.parseInt(nun.substring(0, i) + '5' + nums.substring(i));
    }
}