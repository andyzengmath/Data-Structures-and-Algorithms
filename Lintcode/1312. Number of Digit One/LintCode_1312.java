public class LintCode_1312 {
    /**
     * @param n: an integer 
     * @return: the total number of digit 1
     */
    public int countDigitOne(int n) {
        // write your code here
        int count = 0;
        for (int k = 1; k <= n; k *= 10) {
            // xyzdabc
            int abc = n % k;
            int xyzd = n / k;
            int d = xyzd % 10;
            int xyz = xyzd / 10;
            
            count += xyz * k;
            if (d > 1) {
                count += k;
            }
            if (d == 1) {
                count += abc + 1;
            }
            if (xyz == 0) {
                break;
            }
        }
        return count;
    }
}