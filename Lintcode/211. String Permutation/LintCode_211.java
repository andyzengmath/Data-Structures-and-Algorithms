public class LintCode_211 {
    /**
     * @param A: a string
     * @param B: a string
     * @return: a boolean
     */
    public boolean Permutation(String A, String B) {
        // write your code here
        if (A == null || B == null || A.length() != B.length()) {
            return false;
        }
        int dict = new int[256];
        for (int i = 0; i < A.length(); i++) {
            dict[A.charAt(i)]++;
            dict[B.charAt(i)]--;
        }
        for (int i = 0; i < 256; i++) {
            if (dict[i] != 0) {
                return false;
            }
        }
        return true;

    }
}