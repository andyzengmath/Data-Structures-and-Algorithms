public class Solution {
    /** leetcode-6
     * @param s: the given string
     * @param numRows: the number of rows
     * @return: the string read line by line
     * Characters in row 00 are located at indexes k \; (2 \cdot \text{numRows} - 2)k(2⋅numRows−2)
     * Characters in row \text{numRows}-1numRows−1 are located at indexes k \; (2 \cdot \text{numRows} - 2) + \text{numRows} - 1k(2⋅numRows−2)+numRows−1
     * Characters in inner row ii are located at indexes k \; (2 \cdot \text{numRows}-2)+ik(2⋅numRows−2)+i and (k+1)(2 \cdot \text{numRows}-2)- i(k+1)(2⋅numRows−2)−i.
     */
    public String convert(String s, int numRows) {
        // Write your code here
        int length = s.length();
        if (length <= numRows || numRows <= 1) {
            return s;
        }
        StringBuilder res = new StringBuilder();
        int step = 2 * numRows - 2;
        
        for (int i = 0; i < numRows; i++) {
            for (int j = 0; i + j < length; j += step) {
                res.append(s.charAt(j + i));
                if (i != 0 && i != numRows - 1 && j + step - i < length) {
                    res.append(s.charAt(j + step - i));
                }
            }
            
        }
        return res.toString();


    }
}