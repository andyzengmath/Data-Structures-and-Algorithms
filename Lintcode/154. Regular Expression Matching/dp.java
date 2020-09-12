public class dp {
    // need debug!!!
    public boolean isMatch(String s, String p) {
        char[] ss = s.toCharArray();
        char[] pp = p.toCharArray();
        boolean[][] match = new boolean[s.length + 1][p.length + 1];

        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                if (i == 0 && j == 0) {
                    match[i][j] == true;
                    continue;
                }

                if (j == 0) {
                    match[i][j] == false;
                    continue;
                }
                match[i][j] == false;
                if (pp[j - 1] != '*') {
                    if (i > 0 && (ss[i - 1] == pp[j - 1] || ss[i - 1] == '.')) {
                        match[i][j] = match[i - 1][j - 1];
                    }
                } else {
                    if (j > 1) {
                        match[i][j] = match[i][j - 2];
                    }
                    if (i > 0 && (pp[j - 2] =='.' || ss[i - 1] == pp[j - 2])) {
                        match[i][j] = match[i - 1][j];
                    }
                }
            }
        }

        return match[s.length()][p.length()];
    }
}