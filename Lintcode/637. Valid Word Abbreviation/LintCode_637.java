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

        int wIndex = 0, aIndex = 0;
        while (wIndex < word.length() && aIndex < abbr.length()) {
            if (Character.isDigit(a[aIndex])) {
                if (a[aIndex] == '0') {
                    return false;
                }
                int rep = 0;
                while (aIndex < a.length && Character.isDigit(a[aIndex])) {
                    rep = rep * 10 + (a[aIndex] - '0');
                    aIndex++;
                }
                wIndex += rep;
            } else {
                if (w[wIndex] != a[aIndex]) {
                    return false;
                }
                wIndex++;
                aIndex++; 
            }
           
        }
        return wIndex == word.length() && aIndex == abbr.length();
    }
}
