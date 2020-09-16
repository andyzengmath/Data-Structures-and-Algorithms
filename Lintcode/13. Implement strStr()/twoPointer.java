public class twoPointer {
    public int strStr(String haystack, String needle) {
        int L = needle.length(), n = haystack.length();
        if (L == 0) return 0;

        int pn = 0;
        while (pn < n - L + 1) {
            
            while (pn < n - L + 1 && haystack.charAt(pn) == needle.charAt(0)) { 
                pn++;   
            }
            int curLen = 0, pL = 0;
            while (pL < L && pn < n && haystack.charAt(pn) == needle.charAt(pL)) {
                pn++;
                pL++;
                curLen++;
            }

            if (currLen == L) return pn - L;
            pn = pn - currLen + L;
        }
        return -1;
    }
}