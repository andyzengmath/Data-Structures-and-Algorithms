import java.util.Scanner;

public class PlacingParentheses {
    private static long getMaximValue(String exp) {
      //write your code here
      int n = exp.length() / 2 + 1;
      int [][] min = new int[n][n], max = new int[n][n];

      for (int i = 0; i < n; i ++) {
          min[i][i] = exp.charAt(i * 2) - '0';
          max[i][i] = exp.charAt(i * 2) - '0';
      }

      for (int s = 1; s <= n - 1; s++) {
          for (int i = 0; i <= n - s - 1; i++) {
              int j = s + i;
              int[] result = minAndMax(exp, i, j, min, max);
              min[i][j] = result[0];
              max[i][j] = result[1];
          }
      }
      return max[0][n-1];
    }

    public static int[] minAndMax (String exp, int i, int j, int[][] min, int[][] max) {
        int[] result = new int[]{Integer.MAX_VALUE, Integer.MIN_VALUE};

        for (int index = i; index <= j -1; index ++) {
            char operator = exp.charAt(index * 2 + 1);
            long a = eval(min[i][index], max[index + 1][j], operator);
            long b = eval(min[i][index], min[index + 1][j], operator);
            long c = eval(max[i][index], max[index + 1][j], operator);
            long d = eval(max[i][index], min[index + 1][j], operator);

            result[0] = (int) Math.min(a, Math.min(b, Math.min(c, Math.min(d, result[0]))));
            result[1] = (int) Math.max(a, Math.max(b, Math.max(c, Math.max(d, result[1]))));
        }
        return result;
        
    }

    private static long eval(long a, long b, char op) {
        if (op == '+') {
            return a + b;
        } else if (op == '-') {
            return a - b;
        } else if (op == '*') {
            return a * b;
        } else {
            assert false;
            return 0;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String exp = scanner.next();
        System.out.println(getMaximValue(exp));
    }
}

