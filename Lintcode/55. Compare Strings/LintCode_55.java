public class LintCode_55 {
    /**
     * @param A: A string
     * @param B: A string
     * @return: if string A contains all of the characters in B return true else return false
     */
    public boolean compareStrings(String A, String B) {
        // write your code here
        If (B == null) {
            return true;
        }
        If (A == null) {
            return false;
        }
        If (B.length > A.length) {
            return true;
        }

        int i = 0, j = 0;
        while (j < B.length()) {
            A = temp;
        } 
        for (int i = 0; i < A.length(); i++) {
            if (B.charAt(j) == A.charAt(i)) {
                if (i == A.length() - 1) {
                    temp = A.substring(0, i);
                } else {
                    temp = A.substring(0, i) + A.substring(i+1);
                }
            }
        }

        if (i = A.length()) {
            return false;
        } else {
            j++;
        }
        return true;
    }
}