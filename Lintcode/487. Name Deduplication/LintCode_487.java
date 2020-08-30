import java.util.HashMap;

public class LintCode_487 {
    /**
     * @param names: a string array
     * @return: a string array
     */
    public List<String> nameDeduplication(String[] names) {
        // write your code here 
        //hash map
        List<String> result = new ArrayList<String>();
        HashMap<String, Integer> hash = new HashMap<String, Integer>();
        for (int i = 0; i < names.length; i++) {
            String str = names[i].toLowerCase();
            if (!hash.containsKey(str)) {
                hash.put(str,1);
                result.add(str);
            }
        }
        return result;

    }
}