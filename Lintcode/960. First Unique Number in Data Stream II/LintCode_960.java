public class DataStream {
    private ListNode dummy, tail;
    private Map<Integer, ListNode> numToPrev;
    private Set<Integer> duplicates;

    public DataStream(){
        // do intialization if necessary
        dummy = new ListNode(0);
        tail = dummy;
        numToPrev = new HashMap<>();
        duplicates = new HashSet<>();
    }
    /**
     * @param num: next number in stream
     * @return: nothing
     */
    public void add(int num) {
        // write your code here
        if (duplicates.contains(num)) {
            return;
        }

        if (!numToPrev.containsKey(num)) {
            pushBack(num);
            return;
        }
        duplicates.add(num);
        remove(num);
    }

    private void remove(int num) {
        ListNode prev = numToPrev.get(num);
        numToPrev.remove(num);
        prev.next = prev.next.next;

        if (prev.next != null) {
            numToPrev.put(prev.next.val, prev);
        } else {
            tail = prev;
        }
    }

    private void pushBack(int num) {
        tail.next = new ListNode(num);
        numToPrev.put(num, tail);
        tail = tail.next;
    }

    /**
     * @return: the first unique number in stream
     */
    public int firstUnique() {
        // write your code here
        if (dummy.next == null) return -1;
        return dummy.next.val;
    }
}