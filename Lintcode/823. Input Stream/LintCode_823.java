public class LintCode_823 {
    /**
     * @param inputA: Input stream A
     * @param inputB: Input stream B
     * @return: The answer
     */
    public String inputStream(String inputA, String inputB) {
        // Write your code here
        Stack<Character> stackA = new Stack<>();
        Stack<Character> stackB = new Stack<>();
        char key = '<';
        for (Character c: inputA.toCharArray()) {
            if (c != key) {
                stackA.push(c);
            } else if (!stackA.isEmpty()) {
                stackA.pop();
            }
        }

        for (Character c: inputB.toCharArray()) {
            if (c != key) {
                stackB.push(c);
            } else if (!stackB.isEmpty()) {
                stackB.pop();
            }
        }

        while (!stackA.isEmpty() && !stackB.isEmpty()) {
            if (!(stackA.pop() == stackB.pop())) {
                return "NO";
            }
        }
        return "YES";

    }
}