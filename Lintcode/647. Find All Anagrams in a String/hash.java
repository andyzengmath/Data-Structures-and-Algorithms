import java.util.Map;

public class hash {
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        if (s.length() < p.length()) {
            return ans;
        }

        char[] sc = s.toCharArray();
        char[] pc = p.toCharArray();

        int[] det = new int[256];

        for (int i = 0; i < p.length(); i++) {
            det[pc[i]]--;
            det[sc[i]]++;
        }
        int absSum = 0;
        for (int item: det) {
            absSum += Math.abs(item);
        }

        if (absSum == 0) {
            and.add(0);
        }

        for (int i = p.length(); i < s.length(); i++) {
            int r = sc[i];
            int l = sc[i - p.length()];
            absSum = absSum - Math.abs(det[r]) - Math.abs(det[l]);
            det[r]++;
            det[l]--;

            absSum = absSum + Math.abs(det[r]) + Math.abs(det[l]);
            if (absSum == 0) {
                ans.ad(i - p.length() + 1);
            }
        }

        return ans;

    }
}
