public class LintCode_12 {
    private Stack<Integer> main;
    private Stack<Integer> min;

    public LintCode_12() {
        // do intialization if necessary
        main = new Stack<Integer>();
        min = new Stack<Integer>();
    }

    /*
     * @param number: An integer
     * @return: nothing
     */
    public void push(int number) {
        // write your code here
        if (min.isEmpty()) {
            min.push(number);
        } else if (number <= min.peek()) {
            min.push(number);
        }
        main.push(number);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        // write your code here
        if (main.peek().equals(min.peek())) {
            min.pop();
        }
        return main.pop();
    }

    /*
     * @return: An integer
     */
    public int min() {
        // write your code here
        return min.peek();
    }
}