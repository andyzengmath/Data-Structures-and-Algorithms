public class LintCode_1380 {
    /**
     * @param logs: the logs
     * @return: the log after sorting
     */
    public String[] logSort(String[] logs) {
        // Write your code here
        Arrays.sort(logs, (log1, log2) -> {
            String[] split1 = log1.split(" ", 2);
            String[] split2 = log2.split(" ", 2);
            boolean isDigit1 = Character.isDigit(split1[1].charAt(0));
            boolean isDigit2 = Character.isDigit(split2[1].charAt(0));
            if (!isDigit1 && !isDigit2) {
                int res = split1[1].compareTo(split2[1]);
                if (res != 0) return res;
                return split1[0].compareTo(split2[0]);
            }
            
            return isDigit1 ? (isDigit2 ? 0 : 1) : - 1;
        });
        return logs;
    }
}