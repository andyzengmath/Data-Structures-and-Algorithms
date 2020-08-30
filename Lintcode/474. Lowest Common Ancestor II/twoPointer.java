public class twoPointer {
    public ParentTreeNode lowestCommonAncestorII(ParentTreeNode root, ParentTreeNode A, ParentTreeNode B) {
        ParentTreeNode p1 = A, p2 = B;
        while (p1 != p2) {
            p1 = p1.parent == null ? B : p1.parent;
            p2 = p2.parent == null ? A : p2.parent;
        }
        return p2;
    }
}