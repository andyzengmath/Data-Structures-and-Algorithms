public class LintCode_757 {
    /**
     * @param arr: an array of integers
     * @return: the length of the shortest possible subsequence of integers that are unordered
     */
    public int shortestUnorderedArray(int[] arr) {
        // write your code here
        if (arr.length == 1) {
            return 0;
        }

        int ans = 1;
        int pos = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] != arr[i - 1]) {
                if (arr[i] < arr[i - 1]) {
                    ans = -1;
                    pos = i;
                    break;
                }
            }
        }

        for (int i = pos + 1; i < arr.length; i++) {
            if (ans == -1) {
                if (arr[i] > arr[i - 1]) {
                    return 3;
                } 
            } else {
                if (arr[i] < arr[i - 1]) {
                    return 3;
                }
            }
        }

        return 0;
    }
}