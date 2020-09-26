class LeetCode_83:
    def deleteDuplicates(self, head: ListNode) -> ListNode:
        if not head or not head.next:
            return head
        
        dummy = ListNode(-1)
        dummy.next = head
        while (head.next):
            if head.val == head.next.val:
                head.next = head.next.next
            else:
                head = head.next
        return dummy.next