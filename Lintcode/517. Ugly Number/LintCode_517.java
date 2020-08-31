public class LintCode_517 {
    /**
     * @param num: An integer
     * @return: true if num is an ugly number or false
     */
    public boolean isUgly(int n) {
        // write your code here
        if (n <= 0) {
            return false;
        } else if (n == 1) {
            return true;
        } 
        while (n >= 2 && n % 2 == 0) n /= 2;
        while (n >= 3 && n % 3 == 0) n /= 3;
        while (n >= 5 && n % 5 == 0) n /= 5;

        return n == 1;
    }
}