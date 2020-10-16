public class LintCode_40 {
    private Stack<Integer> ordered;
    private Stack<Integer> buffer;

    public LintCode_40() {
        // do intialization if necessary
        ordered = new Stack<Integer>();
        buffer = new Stack<Integer>();
    }

    /*
     * @param element: An integer
     * @return: nothing
     */
    public void push(int element) {
        buffer.push(element);
    }

    /*
     * @return: An integer
     */
    public int pop() {
        if (! ordered.isEmpty()) {
            return ordered.pop();
        } else {
            while (! buffer.isEmpty()) {
                ordered.push(buffer.pop());
            }
            return ordered.pop();
        }
    }

    /*
     * @return: An integer
     */
    public int top() {
        if (! ordered.isEmpty()) {
            return ordered.peek();
        } else {
            while (! buffer.isEmpty()) {
                ordered.push(buffer.pop());
            }
            return ordered.peek();
        }
    }
}