import java.util.*;
public class LintCode_491 {
    /**
     * @param num: a positive number
     * @return: true if it's a palindrome or false
     * Coud you solve it without converting the integer to a string?
     */
    public boolean isPalindrome(int num) {
        String number = Integer.toString(num);
        int len = number.length();
        for (int i = 0; i < len/2; i++){
            char front = number.charAt(i);
            char back = number.charAt(len - i - 1);
            if ( front != back){
                return false;
            } 
        }

        return true;


    }
    
    public void test(){
        System.out.println(isPalindrome(451));
    }

    public static void main(String args[]){
        LintCode_491 sol = new LintCode_491();
        sol.test();
    }
    

}