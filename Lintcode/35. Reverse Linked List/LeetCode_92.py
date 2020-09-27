# Definition for singly-linked list.
# class ListNode:
#     def __init__(self, val=0, next=None):
#         self.val = val
#         self.next = next
class LeetCode_92:
    def reverseBetween(self, head: ListNode, m: int, n: int) -> ListNode:
        if not head or m >= n:
            return head
        dummy = ListNode(-1)
        dummy.next = head
        head = dummy
        
        for i in range(m - 1):
            head = head.next
        pre = head
        m_node = head.next
        n_node = head.next
        post = n_node.next
        
        for i in range(n - m):
            if n_node == None:
                return None
            temp = post.next
            post.next = n_node
            n_node = post
            post = temp
            
        m_node.next = post
        pre.next = n_node
        
        return dummy.next
            
        