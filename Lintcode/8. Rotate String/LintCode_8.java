public class LintCode_8 {
    /**
     * @param str: An array of char
     * @param offset: An integer
     * @return: nothing
     */
    public void rotateString(char[] str, int offset) {
        // write your code here
        int len = str.length;
        char[] rotated = new char[len];
        if (offset == 0) {
            return;
        } else if (str == null || len == 0 || offset % len == 0) {
            return;
        } else {
            offset = offset % len;
            for (int i = 0; i < len - offset; i++) {
                rotated[offset + i] = str[i];
            }
            for (int j = 0; j < offset; j++) {
                
                rotated[j] = str[j + len - offset];
            }
            
            for (int k = 0;k < len;k++){
			str[k]=rotated[k];
            }
            System.out.println(str);
        }
    }

    public void test(){
        char[] set = new char[]{'a','b','c','c','b','a'};
        rotateString(set, 3);
    }

    public static void main(String args[]){
        LintCode_8 sol = new LintCode_8();
        sol.test();
    }
}