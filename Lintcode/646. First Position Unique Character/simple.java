public class simple {
    public int firstUniqChar(String s) {
        if (s == null || s.length() == 0) {
            return -1;
        }

        int[] alp = new int[256];
        char[] arr = s.toCharArray();

        for (char c: arr) {
            alp[c]++;
        }

        for (int i = 0; i < arr.length; i++) {
            if (alp[arr[i]] == 1) return i;
        }

        return -1;
    }
}
