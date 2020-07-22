import java.util.*;

public class LCS2 {

    private static int lcs2(int[] a, int[] b) {
        //Write your code here
        int s1 = a.length;
        int s2 = b.length;
        int[][] matrix = new int[s1 + 1][s2 + 1];

        for (int i = 0; i <= s1; i ++) {
            matrix[i][0] = 0;
        }

        for (int j = 0; j <= s2; j ++) {
            matrix[0][j] = 0;
        }   

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                if (a[i-1] == b[j-1]) {
                    matrix[i][j] = matrix[i-1][j-1] + 1;
                } else {
                    matrix[i][j] = Math.max(matrix[i-1][j], matrix[i][j-1]);
                }
            }
        }

        return matrix[s1][s2];


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.nextInt();
        }

        int m = scanner.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = scanner.nextInt();
        }

        System.out.println(lcs2(a, b));
    }
}

