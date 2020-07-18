import java.util.Scanner;

public class ChangeDP {
    private static int getChange(int m) {
        //write your code here
        int[] coins = new int[]{1,3,4};
        int[] minNumCoins = new int[m + 1];
        minNumCoins[0] = 0;
        for (int i = 1; i <= m; i ++) {
            minNumCoins[i] = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (i >= coins[j]) {
                    int numCoins = minNumCoins[i - coins[j]] + 1;
                    if (numCoins < minNumCoins[i]) {
                        minNumCoins[i] = numCoins;
                    }
                }
            }
        }
        return minNumCoins[m];
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int m = scanner.nextInt();
        System.out.println(getChange(m));

    }
}

