public class LintCode_1299 {
    public String getHint(String secret, String guess) {
        HashMap<Character, Integer> hash = new HashMap<>();
        int bulls = 0, cows = 0;
        int n = guess.length();
        for (int i = 0; i < n; i++) {
            char s = secret.charAt(i);
            char g = guess.charAt(i);
            if (s == g) {
                bulls++;
            } else {
                if (hash.getOrDefault(s, 0) < 0) cows++;
                if (hash.getOrDefault(g, 0) > 0) cows++;
                hash.put(s, hash.getOrDefault(s, 0) + 1);
                hash.put(g, hash.getOrDefault(g, 0) - 1);
            }
        }
        return Integer.toString(bulls) + "A" + Integer.toString(cows) + "B";
    }
}