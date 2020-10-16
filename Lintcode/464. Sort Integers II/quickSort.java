public class quickSort {
    public void sortIntegers2(int[] A) {
        quicksort(A, 0, A.length - 1);

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
            while (left <= right && num[left] < pivot) {
                left = left + 1;
            } 
            while (left <= right && num[right] > pivot) {
                right = right - 1;
            }

            if (left <= right) {
                swap(num, left, right);
                right = right - 1;
                left = left + 1;
            }
            
        }
        
        
        quicksort(num, start, right);
        quicksort(num, left, end);
    }
    

    public static void swap(int[] num, int a, int b) {
        int temp = num[a];
        num[a] = num[b];
        num[b] = temp;
    }
}