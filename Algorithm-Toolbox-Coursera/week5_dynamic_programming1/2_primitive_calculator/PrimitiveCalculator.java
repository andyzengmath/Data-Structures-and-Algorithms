import java.util.*;

public class PrimitiveCalculator {
    private static List<Integer> optimal_sequence(int n) {
        List<Integer> sequence = new ArrayList<Integer>();
     

        int[] minSequence = new int[n + 1];
        int[] predecessor = new int[n + 1];
        minSequence[0] = 0;
        minSequence[1] = 0;

        

        for (int i = 2; i < n + 1; i ++) {
            minSequence[i] = Integer.MAX_VALUE;
            int num1 = Integer.MAX_VALUE, num2 = Integer.MAX_VALUE, num3 = Integer.MAX_VALUE;
            num1 = minSequence[i-1] + 1;
            predecessor[i] = i - 1;
            if (i % 2 == 0) {
                num2 = minSequence[fun2(i)] + 1;
                predecessor[i] = i / 2;
            }

            if (i % 3 == 0) {
                num3 = minSequence[fun3(i)] + 1;
                predecessor[i] = i / 3;
            }
            int minNum = Math.min(num1, Math.min(num2, num3));

            minSequence[i] = minNum;
        }

        for (int i = n; i != 0; i = predecessor[i]) {
            sequence.add(i);
        }
        Collections.reverse(sequence);
           
        
        return sequence;
    }

    private static int fun1 (int n) {
        return n - 1;
    }

    private static int fun2 (int n) {
        return n / 2;
    }

    private static int fun3 (int n) {
        return n / 3;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        List<Integer> sequence = optimal_sequence(n);
        System.out.println(sequence.size() - 1);
        for (Integer x : sequence) {
            System.out.print(x + " ");
        }
    }
}

