public class LintCode_1288 {
    /**
     * @param tickets: 
     * @return: nothing
     */
    Map<String, PriorityQueue<String>> map = new HashMap<String, PriorityQueue<String>>();
    List<String> intinerary = new LinkedList<String>();
    
    public List<String> findItinerary(List<List<String>> tickets) {
        // Write your code here
        for (List<String> ticket: tickets) {
            String src = ticket.get(0), dst = ticket.get(1);
            if (!map.containsKey(src)) {
                map.put(src, new PriorityQueue<String>());
            }
            map.get(src).offer(dst);
        }
        dfs("JFK");
        Collections.reverse(intinerary);
        return intinerary;
    }
    
    public void dfs(String curr) {
        while (map.containsKey(curr) && map.get(curr).size() > 0) {
            String tmp = map.get(curr).poll();
            dfs(tmp);
        }
        intinerary.add(curr);
    }
}