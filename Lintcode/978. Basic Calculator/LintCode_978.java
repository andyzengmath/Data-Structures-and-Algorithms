public class LintCode_978 {
    /** not pass!
     * 
     * @param s: the given expression
     * @return: the result of expression
     */
    /** Leet 224 can be adapted to 227 as well
     * @param s: the given expression
     * @return: the result of expression
     */
    public int calculate(String s) {
        // Write your code here
        s = s.trim();
        return evaluate(s.toCharArray());
    }
    private int i = 0;
    private int evaluate(char[] chs) {
        Stack<Integer> stack = new Stack<>();
        int num = 0;
        char operation = '+';
        for (; i < chs.length; i++) {
            if (chs[i] == ' ') {
                continue;
            }
            if (Character.isDigit(chs[i])) {
                num = num * 10 + (chs[i] - '0');
            } else if (chs[i] == '(') {
                i++;
                num = evaluate(chs);
                i++;
            }  else if (chs[i] == ')'){
                break;
            }

            if (!Character.isDigit(chs[i]) || i >= chs.length - 1) {
                if (operation == '+') {
                    stack.push(num);
                } else if (operation == '-') {
                    stack.push(-num);
                }

                if (i >= chs.length - 1) {
                    break;
                }
                operation = chs[i];
                num = 0;
            }
            
        }
        int sum = 0;
        while (!stack.isEmpty()) {
            sum += stack.pop();
        }
        return sum;
    }
}