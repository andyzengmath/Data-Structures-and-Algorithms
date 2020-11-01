public class LintCode_616 {
    /*
     * @param numCourses: a total of n courses
     * @param prerequisites: a list of prerequisite pairs
     * @return: the course order
     */
    List<List<Integer>> edges;
    int[] indeg;
    int[] result;
    int index;
    
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        // write your code here
        edges = new ArrayList<>();
        for (int i = 0; i < numCourses; i++) {
            edges.add(new ArrayList<>());
        }
        indeg = new int[numCourses];
        result = new int[numCourses];
        for (int[] info: prerequisites){
            edges.get(info[1]).add(info[0]);
            indeg[info[0]]++;
        }
        
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < numCourses; i++) {
            if (indeg[i] == 0) {
                queue.offer(i);
            }
        }
        
        while (!queue.isEmpty()) {
            int u = queue.poll();
            result[index++] = u;
            for (int v: edges.get(u)) {
                indeg[v]--;
                if (indeg[v] == 0) {
                    queue.offer(v);
                }
            }
        }
        
        if (index != numCourses) {
            return new int[0];
        }
        return result;
    }
}