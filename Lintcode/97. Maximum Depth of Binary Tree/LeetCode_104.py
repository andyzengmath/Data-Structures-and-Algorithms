# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class LeetCode_104:
    # BFS
    def maxDepth(self, root: TreeNode) -> int:
        if not root:
            return 0;
        queue = [root]
        ans = 0
        while queue:
            size = len(queue)
            for i in range(size):
                node = queue.pop(0)
                if node.left:
                    queue.append(node.left)
                if node.right:
                    queue.append(node.right)
            ans += 1
        return ans