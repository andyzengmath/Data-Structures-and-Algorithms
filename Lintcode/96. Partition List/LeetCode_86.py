# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class LeetCode_86:
    def partition(self, head: ListNode, x: int) -> ListNode:
        if not head or not head.next:
            return head
        left_dummy = ListNode(-1)
        right_dummy = ListNode(-1)
        left = left_dummy
        right = right_dummy
        
        while head:
            if head.val < x:
                left.next = head 
                left = left.next
            else:
                right.next = head
                right = right.next
            head = head.next
            
        right.next = None
        left.next = right_dummy.next
        return left_dummy.next
            