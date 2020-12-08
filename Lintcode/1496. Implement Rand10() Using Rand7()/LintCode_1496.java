// The rand7() API is already defined for you.
// int rand7();
// @return a random integer in the range 1 to 7
public class Solution extends SolBase{
    public int rand10() {
        while (true) {
            int rand49 = (rand7() - 1) * 7 + rand7() - 1;
            if (rand49 <= 39) {
                return rand49 / 4 + 1;
            }
        }
    }
}