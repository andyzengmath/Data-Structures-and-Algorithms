public class LinkedList {
    public int[] anagramMappings(int[] A, int[] B) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < B.length; i++) {
            if (!map.containsKey(B[i])) {
                map.put(B[i], new LinkedList<Integer>());
            }
            map.get(B[i]).add(i);
        }

        int[] res = new int[A.length];
        for (int i = 0; i < A.length; i++) {
            List<Integer> list = map.get(A[i]);
            int index list.get(list.size() - 1);
            res[i] = index;
            list.remove(list.size() - 1);
        }

        return result;
    }
}