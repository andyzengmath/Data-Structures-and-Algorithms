public class LintCode_209 {
    /**Google,Amazon,Microsoft,Bloomberg
     * @param str: str: the given string
     * @return: char: the first unique character in a given string
     */
    public char firstUniqChar(String str) {
        // Write your code here
        int[] list = new int[256];
        char[] string = str.toCharArray();
        
        for (int i = 0; i < str.length(); i++) {
            list[string[i]]++;
        }
        int j = 0;
        while (list[string[j]]!=1) {
            j++;
        }
        return string[j];

    }
}