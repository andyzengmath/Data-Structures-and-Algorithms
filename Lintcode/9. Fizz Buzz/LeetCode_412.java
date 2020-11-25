class LeetCode_412 {
    public List<String> fizzBuzz(int n) {
        List<String> ans = new ArrayList<String>();
        HashMap<Integer, String> dict = new HashMap<Integer, String>(){
            {
                put(3, "Fizz");
                put(5, "Buzz");
            }
        };
        for (int num = 1; num <= n; num++) {
            String numAnsStr = "";
            for (Integer key: dict.keySet()) {
                if (num % key == 0) {
                    numAnsStr += dict.get(key);
                }
            }
            if (numAnsStr.equals("")) {
                numAnsStr += Integer.toString(num);
            }
            ans.add(numAnsStr);
        }
        
        return ans;
    }
}