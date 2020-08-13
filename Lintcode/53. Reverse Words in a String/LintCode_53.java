public class LintCode_53 {
    /*
     * @param s: A string
     * @return: A string
     */
    public String reverseWords(String s) {
        // write your code here
        if (s.length() == 0 || s == null) {
            return " ";
        }
        
        Stack<String> stack = new Stack<>();
        String temp = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ' ' && !temp.equals("")) {
                stack.push(temp);
                temp = "";
            } else if (s.charAt(i) != ' ') {
                temp += s.charAt(i);
            }
        }

        stack.push(temp);
        String result = "";
        while (!stack.isEmpty()) {
            result += stack.pop() + " ";
        }
        result = result.substring(0, result.length() - 1);
        return result;
    }
}