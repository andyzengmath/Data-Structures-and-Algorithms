public class set {
    public boolean isUnique(String str) {
        if (s == null || s.length() == 0) {
            return true;
        }
        boolean[] charSet = new boolean[256];
        for (int i = 0; i < str.length(); i++) {
            int val = str.charAt(i);
            if (char_set[val]) {
                return false;
            }          
        }
        return true;
    }
}