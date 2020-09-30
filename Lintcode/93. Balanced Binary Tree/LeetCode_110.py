# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class LeetCode_110:
    def isBalanced(self, root: TreeNode) -> bool:
        return self.getDepth(root) != -1
    
    def getDepth(self, root):
        if not root:
            return 0
        left_height = self.getDepth(root.left)
        right_height = self.getDepth(root.right)
        
        if left_height == -1 or right_height == -1 or abs(left_height - right_height) > 1:
            return -1
        else:
            return max(left_height, right_height) + 1
        
        