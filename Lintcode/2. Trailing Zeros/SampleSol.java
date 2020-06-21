public class SampleSol {
    /*
     * @param n: An integer
     * @return: An integer, denote the number of trailing zeros in n!
     */
    public long trailingZeros(long n) {
        // write your code here, try to do it without arithmetic operators.
        // write your code here, try to do it without arithmetic operators.
        
        long numOfZeros = 0;
       


        while ( n != 0) {
    
            numOfZeros += n / 5;
            n = n / 5; 
        }

        return numOfZeros;
    }
}