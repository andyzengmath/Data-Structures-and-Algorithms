import java.util.*;

public class LargestNumber {
    private static String largestNumber(String[] a) {
        //write your code here
        List<String> list = new ArrayList<String>(Arrays.asList(a));
        String result = "";
        while (list.isEmpty() == false) {
            String max = list.get(0);
            for (int i = 1; i < list.size(); i++) {
                String currDigit = list.get(i);
                if (isGreaterOrEqual(currDigit, max) == true) {
                    max = currDigit;
                }
            }
            result += max;
            list.remove(max);
        }

        
        return result;
    }

    public static boolean isGreaterOrEqual(String digit, String maxDigit) {
        Integer firstSecond = Integer.parseInt(String.valueOf(digit + maxDigit));
        Integer secondFirst = Integer.parseInt(String.valueOf(maxDigit + digit));

        int value = firstSecond.compareTo(secondFirst);

        if (value >= 0) {
            return true;
        } else {
            return false;
        }
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

