public class LintCode_1309 {
    /** slow
     * @param input: a string
     * @return: return List[int]
     */
    Map<String, List<Integer>> map = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String input) {
        // write your code here
        if (input.length() == 0) return new ArrayList<>();
        if (map.containsKey(input)) return map.get(input);
        List<Integer> result = new ArrayList<>();
        int num = 0; 
        int index = 0;
        while (index < input.length() && !isOperation(input.charAt(index))) {
            num = num * 10 + input.charAt(index) - '0';
            index++;
        }
        if (index == input.length()) {
            result.add(num);
            map.put(input, result);
            return result;
        }
        
        for (int i = 0; i < input.length(); i++) {
            if (isOperation(input.charAt(i))) {
                List<Integer> result1 = diffWaysToCompute(input.substring(0, i));
                List<Integer> result2 = diffWaysToCompute(input.substring(i + 1));
                for (int j = 0; j < result1.size(); j++) {
                    for (int k = 0; k < result2.size(); k++) {
                        char op = input.charAt(i);
                        result.add(calculate(result1.get(j), op, result2.get(k)));
                    }
                }
            }
        }
        map.put(input, result);
        return result;
    }
    
    private int calculate(int num1, char c, int num2) {
        switch (c) {
            case '+':
                return num1 + num2;
            case '-':
                return num1 - num2;
            case '*':
                return num1 * num2;
        }
        return -1;
    }
    
    private boolean isOperation(char c) {
        return c == '+' || c == '-' || c == '*';
    }
}