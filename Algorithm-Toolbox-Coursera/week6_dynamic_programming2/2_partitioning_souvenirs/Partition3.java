import java.util.*;
import java.io.*;

public class Partition3 {
    private static int partition3(int[] A) {
        //write your code here
        int n = A.length;
        int sum = 0;

	    for (int value : A) {
	        sum += value;
        }
        
        if (sum % 3 != 0) {
            return 0;
        }
        int W = sum / 3;
        int count = 0;

        int[][] value = new int[W + 1][n + 1];

        for (int i = 0; i <= W; i ++) {
            value[i][0] = 0;
        }

        for (int j = 0; j <= n; j ++) {
            value[0][j] = 0;
        }

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= W; j++) {
                value[j][i] = value[j][i-1];
                if (A[i - 1] <= j) {
                    int val = value[j - A[i - 1]][i-1] + A[i-1];
                    if (value[j][i] < val) {
                        value[j][i] = val;
                    }
                }
                if (value[j][i] == W) {
                    count += 1;
                }
            }
        }

        if (count < 3) {
            return 0;
        } else {
            return 1;
        }
        


    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        int[] A = new int[n];
        for (int i = 0; i < n; i++) {
            A[i] = scanner.nextInt();
        }
        System.out.println(partition3(A));
    }
}

