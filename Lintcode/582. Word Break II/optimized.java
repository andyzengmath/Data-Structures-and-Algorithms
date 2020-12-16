public class Solution {
    /*
     * @param s: A string
     * @param wordDict: A set of words.
     * @return: All possible sentences.
     */
    public List<String> wordBreak(String s, Set<String> wordDict) {
        // write your code here
        Map<String, ArrayList<String>> memo = new HashMap<String, ArrayList<String>>();
        return wordBreakHelper(s, wordDict, memo);
    }
    
    private ArrayList<String> wordBreakHelper(String s, Set<String> wordDict, Map<String, ArrayList<String>> memo) {
        if (memo.containsKey(s)) {
            return memo.get(s);
        }
        ArrayList<String> partitions = new ArrayList<String>();
        if (s.length() == 0) {
            return partitions;
        }
        if (wordDict.contains(s)) {
            partitions.add(s);
        }
        
        for (int i = 1; i < s.length(); i++) {
            String prefix = s.substring(0, i);
            if (!wordDict.contains(prefix)) {
                continue;
            }
            String suffix = s.substring(i);
            ArrayList<String> subPartitions = wordBreakHelper(suffix, wordDict, memo);
            for (String partition: subPartitions) {
                partitions.add(prefix + " " + partition);
            }
        }
        memo.put(s, partitions);
        return partitions;
    }
}