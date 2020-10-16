public class divideAndConquer_480 {
    public List<String> paths = new ArrayList<>();
    if (root == null) {
        return paths;
    }

    List<String> leftPaths = binaryTreePaths(root.left);
    List<String> rightPaths = binaryTreePaths(root.right);

    for (String path: leftPaths) {
        paths.add(root.val + "->" + path);
    }
    for (String path: rightPaths) {
        paths.add(root.val + "->" + path);
    }

    if (paths.size() == 0) {
        paths.add("" + root.val);
    }

    return paths;
}