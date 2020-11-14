public class LintCode_980 {
    /**
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        if (s == null || s.length() == 0) return 0;
        Stack<Integer> stack = new Stack<>();
        int currNum = 0;
        char operation = '+';
        
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (Character.isDigit(currChar)) {
                currNum = (currNum * 10) + (currChar - '0');
            }
            if (!Character.isDigit(currChar) && !Character.isWhitespace(currChar) || i == s.length() - 1) {
                if (operation == '-') {
                    stack.push(-currNum);
                } else if (operation == '+') {
                    stack.push(currNum);
                } else if (operation == '*') {
                    stack.push(stack.pop() * currNum);
                } else if (operation == '/') {
                    stack.push(stack.pop() / currNum);
                }
                operation = currChar;
                currNum = 0;
            }
        }
        int res = 0;
        while (!stack.isEmpty()) {
            res += stack.pop();
        }
        return res;
    }
}