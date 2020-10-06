/**
 * Definition for singly-linked list with a random pointer.
 * class RandomListNode {
 *     int label;
 *     RandomListNode next, random;
 *     RandomListNode(int x) { this.label = x; }
 * };
 */
public class LintCode_105 {
    /**
     * @param head: The head of linked list with a random pointer.
     * @return: A new head of a deep copy of the list.
     */
    HashMap<RandomListNode, RandomListNode> visited = new HashMap<>(); 
    public RandomListNode copyRandomList(RandomListNode head) {
        // write your code here
        if (head == null) return null;
        if (this.visited.containsKey(head)) {
            return this.visited.get(head);
        }
        RandomListNode node = new RandomListNode(head.label);
        this.visited.put(head,node);
        node.next = this.copyRandomList(head.next);
        node.random = this.copyRandomList(head.random);

        return node;
    }
}