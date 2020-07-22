import java.util.*;

public class LCS3 {

    private static int lcs3(int[] a, int[] b, int[] c) {
        int s1 = a.length;
        int s2 = b.length;
        int s3 = c.length;

        int[][][] matrix = new int[s1][s2][s3];

        for (int i = 0; i <= s1; i ++) {
            matrix[i][0][0] = 0;
        }

        for (int j = 0; j <= s2; j ++) {
            matrix[0][j][0] = 0;
        }
        
        for (int k = 0; k <= s3; k ++) {
            matrix[0][0][k] = 0;
        }  

        for (int i = 1; i <= s1; i++) {
            for (int j = 1; j <= s2; j++) {
                for (int k = 1; k <= s3; k++) {
                    if (a[i-1] == b[j-1] && a[i-1] == c[k-1]) {
                        matrix[i][j][k] = matrix[i-1][j-1][k-1] + 1;
                    } else {
                        matrix[i][j][k] = Math.max(matrix[i][j][k-1], Math.max(matrix[i-1][j][k], matrix[i][j-1][k]));
                    }
                }
                
            }
        }

        return matrix[s1][s2][s3];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int an = scanner.nextInt();
        int[] a = new int[an];
        for (int i = 0; i < an; i++) {
            a[i] = scanner.nextInt();
        }
        int bn = scanner.nextInt();
        int[] b = new int[bn];
        for (int i = 0; i < bn; i++) {
            b[i] = scanner.nextInt();
        }
        int cn = scanner.nextInt();
        int[] c = new int[cn];
        for (int i = 0; i < cn; i++) {
            c[i] = scanner.nextInt();
        }
        System.out.println(lcs3(a, b, c));
    }
}

