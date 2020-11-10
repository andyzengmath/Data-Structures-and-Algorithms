public class LintCode_1095 {
    /**
     * @param num: a non-negative intege
     * @return: the maximum valued number
     */
    public int maximumSwap(int num) {
        // Write your code here
        if (num < 10) return num;
        char[] charArr = String.valueOf(num).toCharArray();
        int[] maxArr = new int[charArr.length];
        int max = charArr.length - 1;
        
        for (int i = charArr.length - 1; i >= 0; i--) {
            if (charArr[i] > charArr[max]) {
                max = i;
                maxArr[i] = -1;
            } else {
                maxArr[i] = max;
            }
        }
        
        for (int i = 0; i < maxArr.length; i++) {
            if (maxArr[i] != -1 && charArr[i] != charArr[maxArr[i]]) {
                swap(charArr, i, maxArr[i]);
                break;
            }
        }
        
        return Integer.parseInt(new String(charArr));
    }
    
    private void swap(char[] charArr, int i, int j) {
        char temp = charArr[i];
        charArr[i] = charArr[j];
        charArr[j] = temp;
    }
}