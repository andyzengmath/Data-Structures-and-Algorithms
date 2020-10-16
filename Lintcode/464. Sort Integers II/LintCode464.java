public class LintCode464 {
    /**
     * @param A: an integer array
     * @return: nothing
     * 
     * Use quick sort, merge sort, heap sort or any O(nlogn) algorithm.
     */
    public void sortIntegers2(int[] A) {
        // write your code here
        // quicksort
        if (A == null || A.length <= 1) {
            return;
        } else {
            int pIndex = A.length / 2;
            int loc = partition(A, pIndex);
            sortIntegers2(Arrays.copyOfRange(A, 0, loc));
            sortIntegers2(Arrays.copyOfRange(A, loc + 1, A.length));
        }
    }

    private static int partition (int[] A, int pIndex) {
        int pivot = A[pIndex];
        int hi = A.length - 1;
        swap(A, pIndex, hi);
        int left = 0;
        int right = hi - 1;
        while (left <= right) {
            if (A[left] <= pivot) {
                left = left + 1;
            } else {
                swap(A, left, right);
                right = right - 1;
            }
            
        }
        swap(A, left, hi);
        return left;

    }

    private static void swap (int[] A, int a, int b) {
        int temp = A[a];
        A[a] = A[b];
        A[b] = temp;
    }
}