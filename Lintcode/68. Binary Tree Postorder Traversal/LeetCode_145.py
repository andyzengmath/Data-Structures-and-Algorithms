# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class LeetCode_145:
    def postorderTraversal(self, root: TreeNode) -> List[int]:
        if not root:
            return list()
        result = list()
        stack = list()
        prev = None
        
        while root or stack:
            while root:
                stack.append(root)
                root = root.left
            root = stack.pop()
            
            if not root.right or root.right == prev:
                result.append(root.val)
                prev = root
                root = None
            else:
                stack.append(root)
                root = root.right
                
        return result
        