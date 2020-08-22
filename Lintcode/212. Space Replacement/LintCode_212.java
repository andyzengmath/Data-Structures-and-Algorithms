public class LintCode_212 {
    /*Do it in-place.
     * @param string: An array of Char
     * @param length: The true length of the string
     * @return: The true length of new string
     */
    public int replaceBlank(char[] string, int length) {
        // write your code here
        if (string == null || string.length == 0) {
            return 0;
        }
        int empty = 0;
        for (int i = 0; i < string.length; i++) {
            if (string[i] == ' ') {
                empty++;
            }
        }
        int newLen = string.length + 2 * empty;
        int count = 1;
        for (int j = string.length - 1; j >= 0; j--) {
            if (string[j] == ' ') {
                string[newLen - count] = '0';
                count++;
                string[newLen -count] = '2';
                count++;
                string[newLen - count] = '%';
                count++;
            } else {
                string[newLen - count] = string[j];
                count++;
            }
        }

        return newLen;
    }
}