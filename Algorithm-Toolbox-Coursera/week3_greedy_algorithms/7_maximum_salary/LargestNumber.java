import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        List<String> list = new ArrayList<String>(Arrays.asList(a));
        String result = "";
        while (isEmpty(list) == false) {
            int max = Integer.MIN_VALUE;
            for (int i = 0; i < list.length; i++) {
                int currDigit = list.get(i)
                if (IsGreaterOrEqual(currDigit], max) == true) {
                    max = currDigit;
                }
            }
            result += max;
            list.remove(i);
        }

        
        return result;
    }

    public boolean isGreaterOrEqual (String digit, String maxDigit) {

    }
    /*
    3 909 9 90
    3 9 909 90
    3 90 909 9
    3 90 9 909
    
    Desired Output: 990990
    */

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        String[] a = new String[n];
        for (int i = 0; i < n; i++) {
            a[i] = scanner.next();
        }
        System.out.println(largestNumber(a));
    }
}

