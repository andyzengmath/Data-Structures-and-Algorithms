public class LintCode_684 {
    /**
     * @param str1: a given string
     * @param str2: another given string
     * @return: An array of missing string
     */
    public List<String> missingString(String str1, String str2) {
        // Write your code here
        List<String> result = new ArrayList<>();

        String[] arr1 = str1.split(" ");
        String[] arr2 = str2.split(" ");
        Set<String> set = new HashSet<>();

        for (String str: arr2) {
            set.add(str);
        }

        for (String str: arr1) {
            if (!set.containts(str)) {
                result.add(str);
            }
        }

        return result;
    }
}
