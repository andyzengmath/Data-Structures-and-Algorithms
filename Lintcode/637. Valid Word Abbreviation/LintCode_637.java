public class LintCode_637 {
    /** 
     * @param word: a non-empty string
     * @param abbr: an abbreviation
     * @return: true if string matches with the given abbr or false
     */
    public boolean validWordAbbreviation(String word, String abbr) {
        if (word == null || abbr == null || abbr.length() > word.length()) {
            return false;
        }
        char[] w = word.toCharArray();
        char[] a = abbr.toCharArray();

        int wIndex = 0, int aIndex = 0;
        while (wIndex < word.length() && aIndex < abbr.length()) {
            if (Character.isDigit(a[index])) {
                if (a[index] == 0) {
                    return false;
                }
                int rep = 0;
                while (index < a.length && Character.isDigit(a[index])) {
                    rep = rep * 10 + (a[index] - '0');
                    index++;
                }
                mIndex += value;
            } else {
                if (w[wIndex] != a[index]) {
                    return false;
                }
            }
            wIndex++;
            aIndex++; 
        }
        return position == word.length() && index == abbr.length();
    }
}
