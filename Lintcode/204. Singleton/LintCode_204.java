public class LintCode_204 {
    /**
     * @return: The same instance of this class every time
     * If we call getInstance concurrently, can you make sure your code could run correctly?
     */
    public static Solution instance = null;
    public static Solution getInstance() {
        // write your code here

        if (instance == null) {
            instance = new Solution();
        }
        return instance;
    }
}