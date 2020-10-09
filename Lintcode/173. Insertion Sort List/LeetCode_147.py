# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class LeetCode_147:
    def insertionSortList(self, head: ListNode) -> ListNode:  
        if not head or not head.next:
            return head
        dummy = ListNode(0)

        while head:
            curr = dummy
            
            while curr.next and curr.next.val < head.val:
                curr = curr.next
            temp = head.next
            head.next = curr.next
            curr.next = head
            head = temp
        
        return dummy.next
