/**
 * // This is the interface that allows for creating nested lists.
 * // You should not implement it, or speculate about its implementation
 * public interface NestedInteger {
 *
 *     // @return true if this NestedInteger holds a single integer,
 *     // rather than a nested list.
 *     public boolean isInteger();
 *
 *     // @return the single integer that this NestedInteger holds,
 *     // if it holds a single integer
 *     // Return null if this NestedInteger holds a nested list
 *     public Integer getInteger();
 *
 *     // @return the nested list that this NestedInteger holds,
 *     // if it holds a nested list
 *     // Return null if this NestedInteger holds a single integer
 *     public List<NestedInteger> getList();
 * }
 */
public class LintCode_22 {
    // @param nestedList a list of NestedInteger
    // @return a list of integer
    public List<Integer> flatten(List<NestedInteger> nestedList) {
        // Write your code here
        List<Integer> result = new ArrayList<Integer>();
        Stack<List<NestedInteger>> stack = new Stack<>();
        List<NestedInteger> temp = nestedList;

        while (temp.size() > 0 || stack.size() > 0) {
            if (temp.size() == 0) {
                temp = stack.pop();
            }
            NestedInteger item = temp.remove(0);
            if (item.isInteger()) {
                result.add(item.getInteger());
            } else {
                if (temp.size() > 0) {
                    stack.push(temp);
                };
                temp = item.getList();
            }
        }

        return result;

        
    }
}