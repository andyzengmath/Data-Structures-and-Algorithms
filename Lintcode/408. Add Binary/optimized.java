public class optimized {
    public String addBinary(String a, String b) {
        String result = "";
        int add = 0;
        for (int i = a.length() - 1, j = b.length() - 1; i >= 0 || j >= 0; i--, j--) {
            int sum = add;
            sum += (i >= 0) ? a.charAt(i) - '0' : 0;
            sum += (j >= 0) ? b.charAt(j) - '0' : 0;
            result = (sum % 2) + result;
            add = sum / 2;
        }
        if (add != 0) {
            result = add + result;
        }
        return result;
    }
}