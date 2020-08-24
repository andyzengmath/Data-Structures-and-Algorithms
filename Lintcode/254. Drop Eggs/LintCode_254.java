public class LintCode_254 {
    /** don't understand
     * @param n: An integer
     * @return: An integer
     */
    public int dropEggs(int n) {
        // write your code here
        long result = 0;
        for (int i = 1; ; i++) {
            result += (long) i;
            if (result >= (long)n){
                return i;
            }
                
        }
    }
}