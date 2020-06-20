public class Solution {
    /**
     * @param n: An integer
     * @return: A list of strings.
     */
    public List<String> fizzBuzz(int n) {
        List<String> sol = new ArrayList<String>();
        for (int i = 1; i < n + 1;  i ++ ){
            if (i % 3 == 0){
                if (i % 5 == 0){
                    sol.add("fizz buzz");
                } else {
                    sol.add("fizz");
                }
            } else if (i % 5 == 0) {
                sol.add("buzz");
            } else {
                sol.add(Integer.toString(i));
            }
        }
        return sol;
    }
}