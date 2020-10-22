class LeetCode_415 {
    // 10-22-20 review
    public String addStrings(String num1, String num2) {
        StringBuilder sb = new StringBuilder("");
        int m = num1.length() - 1, n = num2.length() - 1, carry = 0;
        while (n >= 0 || m >= 0) {
            int a = m >= 0 ? (num1.charAt(m--) - '0') : 0;
            int b = n >= 0 ? (num2.charAt(n--) - '0') : 0;
            int temp = a + b + carry;
            carry = temp / 10; //note to save time using temp
            sb.append(temp % 10);
        }
        
        if (carry == 1) sb.append(1);
        return sb.reverse().toString();
    }
}