

public class LintCode_492 {
    /*
     * @param item: An integer
     * @return: nothing
     */

    public Node head, tail;

    class Node {
        public int val;
        public Node next;
        public Node(int _val) {
            val = _val;
            next = null;
        }
    }

    public LintCode_492() {
        head = null;
        tail = null;
    }
    

    public void enqueue(int item) {
        // write your code here
        if (head == null) {
            tail = new Node(item);
            head = tail;
        } else {
            tail.next = new Node(item);
            tail = tail.next;
        }
    }

    /*
     * @return: An integer
     */
    public int dequeue() {
        // write your code here
        if (head == null) {
            return -1;
        } else {
            int deq = head.val;
            head = head.next;
            return deq;
        }
    }
}