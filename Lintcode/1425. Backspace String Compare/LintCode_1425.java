public class LintCode_1425 {
    /**
     * @param S: string S
     * @param T: string T
     * @return: Backspace String Compare
     */
    public boolean backspaceCompare(String S, String T) {
    // Write your code here
        if (S == null || T == null) return false;
        int sBack = 0, tBack = 0;
        int sIndex = S.length() - 1, tIndex = T.length() - 1;
        while (sIndex >= 0 || tIndex >= 0){
            while (sIndex >= 0) {
                if (S.charAt(sIndex) == '#') {
                    sBack++;
                    sIndex--;
                } else if (sBack > 0) {
                    sIndex--;
                    sBack--;
                } else {
                    break;
                }
            }
            while (tIndex >= 0) {
                if (T.charAt(tIndex) == '#') {
                    tBack++;
                    tIndex--;
                } else if (tBack > 0) {
                    tIndex--;
                    tBack--;
                } else {
                    break;
                }
            }
            
            if (sIndex >= 0 && tIndex >= 0) {
                if (S.charAt(sIndex) != T.charAt(tIndex)) {
                    return false;
                }
            } else {
                if (sIndex >= 0 || tIndex >= 0) {
                    return false;
                }
            }
            sIndex--;
            tIndex--;
        } 
            return true;
    }
}