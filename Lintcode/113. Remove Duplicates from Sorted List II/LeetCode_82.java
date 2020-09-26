# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class LeetCode_82:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not (head and head.next):
            return head
        
        dummy = ListNode(-1)
        dummy.next = head
        head = dummy
        while  head.next and  head.next.next:
            if head.next.val == head.next.next.val:
                val = head.next.val
                while head.next and head.next.val == val:
                    head.next = head.next.next
            else:
                head = head.next
                
        return dummy.next