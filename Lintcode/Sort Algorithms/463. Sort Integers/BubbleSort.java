public class BubbleSort {
    public void sortIntegers(int[] A) {
        while (true) {
            boolean exchange = false;
            for (int i = 0; i < A.length - 1; i++) {
                if (A[i] > A[i + i]) {
                    int temp = A[i];
                    A[i] = A[i + 1]];
                    A[i + 1] = temp;
                    exchange = true;
                }
            }
            
            if (!exchange) {
                break;
            }
        }
    }
}