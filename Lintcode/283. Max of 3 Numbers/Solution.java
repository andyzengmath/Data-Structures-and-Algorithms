public class Solution {
    /**
     * @param num1: An integer
     * @param num2: An integer
     * @param num3: An integer
     * @return: an interger
     */
    public int maxOfThreeNumbers(int num1, int num2, int num3) {
        if (num1 >= num2) {
            if (num3 >= num1) {
                return num3;
            } else {
                return num1;
            }
        } else {
            if (num3 >= num2) {
                return num3;
            } else {
                return num2;
            }
        }
    }
}