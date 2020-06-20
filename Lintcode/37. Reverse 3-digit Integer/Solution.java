import java.lang.Math;

public class Solution {
    /**
     * @param number: A 3-digit number.
     * @return: Reversed number.
     */
    // calculate
    public int reverseInteger(int number) {
        int answer = 0;
        int len = String.valueOf(number).length();

        for (int i = 0; i < len; i++){
            System.out.println(number);
            answer = answer +  ((number % 10) * (int) Math.pow(10, (len - i - 1)));
            number = number / 10;
        }

        return answer;
    }

    public void test(){
        
        System.out.println(reverseInteger(451));
    }

    public static void main(String args[]){
        Solution sol = new Solution();
        sol.test();
    }

    
}