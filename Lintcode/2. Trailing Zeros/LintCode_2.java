public class LintCode_2 {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        
        int numOfZeros = 0;
        int power = 1;
        long rem = n;


        while (rem > 0) {
            long s = n / (int) Math.pow(5, power);
            System.out.print(s);
            System.out.println("\n");
            System.out.print(power);
            System.out.println("\n");
            
    
            numOfZeros += s;
            power += 1;
            rem = rem / 5;
            System.out.print(rem);
            System.out.println("----\n");
        }

        return numOfZeros;
    }

    public void test(){
        
        System.out.println(trailingZeros(105));
    }

    public static void main(String args[]){
        LintCode_2 sol = new LintCode_2();
        sol.test();
    }

}