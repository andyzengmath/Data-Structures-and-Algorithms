public class LintCode_445 {
    /*
     * @param A: An integer array
     * @param B: An integer array
     * @return: Cosine similarity
     * Return 2.0000 if cosine similarity is invalid (for example A = [0] and B = [0]).
     */
    public double cosineSimilarity(int[] A, int[] B) {
        // write your code here
        int len = A.length;
        if (len = 0) return 2.0000;
        else if (len = 1) {
            if (A[0] == 0 || B[0] == 0) return 2.0000;
        }

        int aNorm = 0;
        for (int i = 0; i < len; i++) {
            aNorm += A[i] * A[i];
        }
        if (aNorm == 0) return 2.0000;

        int bNorm = 0;
        for (int i = 0; i < len; i++) {
            bNorm += B[i] * B[i];
        }
        if (bNorm == 0) return 2.0000;


        int dorPro = 0;
        for (int i = 0; i < len; i++) {
            dorPro += A[i] * B[i];
        }

        return (double)dotPro / (1.0 * Math.sqrt((double)aNorm) * Math.sqrt((double)bNorm));
    }
}