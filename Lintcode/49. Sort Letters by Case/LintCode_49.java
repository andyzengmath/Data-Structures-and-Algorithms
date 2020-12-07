public class LintCode_49 {
    /*
     * @param chars: The letter array you should sort by Case
     * @return: nothing
     */
    public void sortLetters(char[] chars) {
        // write your code here
        int i = 0, j = chars.length - 1;
        while (i <= j) {
            while (i <= j && Character.isLowerCase(chars[i])) {
                i++;
            }
            while(i <= j && Character.isUpperCase(chars[j])) {
                j--;
            }
            if (i <= j) {
                char temp = chars[i];
                chars[i] = chars[j];
                chars[j] = temp;
                i++;
                j--;
            }
        }
    }
}