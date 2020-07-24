import java.util.*;

public class Knapsack {
    static int optimalWeight(int W, int[] w) {
        //write you code here
        int n = w.length;
        int[][] matrix = new int[W + 1][n + 1];

        for (int i = 0; i <= W; i ++) {
          value[i][0] = 0;
      }

      for (int j = 0; j <= n; j ++) {
          value[0][j] = 0;
      }
      
      for (int i = 1; i <= n; i++) {
        for (int j = 1; j <= M; j++) {
            value[j][i] = value[j][i-1];
            if (w[i - 1] <= j) {
                int val = value[j - w[i - 1]][i-1] + w_i;
                if (value[j][i] < val) {
                    value[j][i] = val;
                }
            }
        }
        }
    

    return matrix[W][n];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int W, n;
        W = scanner.nextInt();
        n = scanner.nextInt();
        int[] w = new int[n];
        for (int i = 0; i < n; i++) {
            w[i] = scanner.nextInt();
        }
        System.out.println(optimalWeight(W, w));
    }
}

