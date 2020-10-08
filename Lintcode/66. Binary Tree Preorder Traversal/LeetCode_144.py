# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class LeetCode_144:
    def preorderTraversal(self, root: TreeNode) -> List[int]:
        if root is None:
            return []
        stack, output = [root, ], []
        
        while stack:
            root = stack.pop()
            output.append(root.val)
            if root.right is not None:
                stack.append(root.right)
            if root.left  is not None:
                stack.append(root.left)
        return output
        