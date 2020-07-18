import java.util.*;

class EditDistance {
  public static int EditDistance(String s, String t) {
    //write your code here
    int m = s.length();
    int n = t.length();
    int[][] matrix = new int[m + 1][n + 1];
    for (int j = 0; j <= n; j ++){
      matrix[0][j] = j;
    }

    for (int i = 0; i <= m; i ++){
      matrix[i][0] = i;
    }


    for (int i = 1; i <= m; i ++){
      for (int j = 1; j <= n; j ++) {
        int insertion = matrix[i][j - 1] + 1;
        int deletion = matrix[i - 1][j] + 1;
        int mismatch = matrix[i - 1][j - 1] + 1;
        int match = matrix[i - 1][j - 1];
        if (s.charAt(i - 1) == t.charAt(j - 1)) {
          matrix[i][j] = Math.min(insertion, Math.min(deletion, match));
        } else {
          matrix[i][j] = Math.min(insertion, Math.min(deletion, mismatch));
        }
      }
    }
    return matrix[m][n];
  }
  public static void main(String args[]) {
    Scanner scan = new Scanner(System.in);

    String s = scan.next();
    String t = scan.next();

    System.out.println(EditDistance(s, t));
  }

}
