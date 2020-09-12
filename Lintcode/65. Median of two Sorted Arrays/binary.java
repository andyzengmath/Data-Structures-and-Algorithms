public class binary {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int m = A.length, n = B.length;
        if ((m + n) % 2 == 1) {
            return getKth(A, 0, A.length - 1, B, 0, B.length - 1, (m + n) / 2 + 1);        
        }
        int left = getKth(A, 0, A.length - 1, B, 0, B.length - 1, (m + n) / 2);
        int right = getKth(A, 0, A.length - 1, B, 0, B.length - 1, (m + n) / 2 + 1);
        return (left + right) / 2.0;
    }

    private int getKth(int[] A, int start1, int end1, int[] B, int start2, int end2, int k) {
        int len1 = end1 - start1 + 1;
        int len2 = end2 - start2 + 1;
        if (len1 > len2) {
            return getKth(B, start2, end2, A, start1, end1, k);
        }
        if (len1 == 0) {
            return B[start2 + k - 1];
        }
        if (k == 1) {
            return Math.min(A[start1], B[start2]);
        }

        int i = start1 + Math.min(len1, k / 2) - 1;
        int j = start2 + Math.min(len2, k / 2) - 1;
        if (A[i] > B[j]) {
            return getKth(A, start1, end1, B, j + 1, end2, k - (j - start2 + 1));
        } else {
            return getKth(A, i + 1, end1, B, start2, end2, k - (i - start1 + 1));
        }
    }
}