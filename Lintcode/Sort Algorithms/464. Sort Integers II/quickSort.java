public class quickSort {
    public void sortIntegers2(int[] A) {
        quickSort(A, 0, A.length - 1);

    }
    
    private void quicksort(int[] num, int start, int end) {
        if (start >= end) {
            return;
        }

        int left = start;
        int right = end;
        int mid = start + (end - start) / 2;
        int pivot = num[mid];

        while (left <= right) {
            if (num[left] <= pivot) {
                left = left + 1;
            } else {
                swap(A, left, right);
                right = right - 1;
            }
            
        }
        swap(A, left, hi);
        quicksort(num, start, right);
        quicksort(num, left, end);
    }
    

    private void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}