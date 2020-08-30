public class LintCode_474 {
    /*
     * @param root: The root of the tree
     * @param A: node in the tree
     * @param B: node in the tree
     * @return: The lowest common ancestor of A and B
     */
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        // write your code here
        // hashset
        Set<ParentTreeNode> parentSet = new HashSet<>();
        ParentTreeNode curr = A;
        while (curr != null) {
            parentSet.add(curr);
            curr = curr.parent;
        }
        curr = B;
        while (curr != null) {
            if (parentSet.contains(curr)) {
                return curr;
            }
            curr = curr.parent;
        }
        return null;
    }
}
/**
 * Definition of ParentTreeNode:
 * 
 * class ParentTreeNode {
 *     public ParentTreeNode parent, left, right;
 * }
 */