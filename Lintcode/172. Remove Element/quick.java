public class quick {
    public int removeElement(int[] A, int elem) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int i = 0, j = A.length - 1;
        while (i <= j) {
            while (i <= j && A[i] != elem) {
                i++;
            }
            while (i <= j && A[j] == elem) {
                j--;
            }
            if (i <= j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
                i++;
                j--;
            }
        }
        return i;
    }

}