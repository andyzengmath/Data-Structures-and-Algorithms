import java.util.*;

public class DifferentSummands {
    private static List<Integer> optimalSummands(int n) {
        List<Integer> summands = new ArrayList<Integer>();
        //write your code here
        int rem = n;
        int currPrize = 1;

        while (rem > 0 && currPrize <= rem) {
            summands.add(currPrize);
            rem = rem - currPrize;
            //System.out.print(currPrize);
            //System.out.println("curr");
            currPrize += 1; 
        }
        if (rem == 0) {
            return summands;
        } else {
            summands.set(currPrize - 2, currPrize + rem - 1);
            return summands;
        }
    }
    
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> summands = optimalSummands(n);
        System.out.println(summands.size());
        for (Integer summand : summands) {
            System.out.print(summand + " ");
        }
    }
}

