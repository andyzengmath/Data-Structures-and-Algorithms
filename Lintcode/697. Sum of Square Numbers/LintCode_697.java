public class LintCode_697 {
    /**
     * @param num: the given number
     * @return: whether whether there're two integers
     */
    public boolean checkSumOfSquareNumbers(int num) {
        // write your code here
        if (num < 0) {
            return false;
        }

        int root = (int)Math.sqrt(num);
        for (int i = 0; i <= root; i++) {
            double b = Math.sqrt(num - i * i);
            if (b == (int)b) {
                return true;
            }
        }
        return false;
    }
}
