public class LintCode_133 {
    /*
     * @param dictionary: an array of strings
     * @return: an arraylist of strings
     * challenge: It's easy to solve it in two passes, can you do it in one pass?
     */
    public List<String> longestWords(String[] dictionary) {
        // write your code here
        List<String> list = new ArrayList<>();
        if (dictionary == null || dictionary.length == 0) {
            return list;
        }
        
        list.add(dictionary[0]);
        int currLen = dictionary[0].length();
        for (int i = 1; i < dictionary.length; i++) {
            if (dictionary[i].length() > currLen) {
                list.clear();
                list.add(dictionary[i]);
                currLen = dictionary[i].length();
            } else if (dictionary[i].length() == currLen) {
                list.add(dictionary[i]);
            }        
        }
        return list;    
   
    }
}