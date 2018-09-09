# Definition for singly-linked list.
class ListNode:
     def __init__(self, x):
         self.val = x
         self.next = None

class Solution:
    def addTwoNumbers(self, l1, l2):
        """
        :type l1: ListNode
        :type l2: ListNode
        :rtype: ListNode
        """
       
        result = ListNode(0)
        temp = result
        carry = 0
        while l1 or l2:
            sum = carry
            if l1:
                sum += l1.val
                l1 = l1.next
            if l2:
                sum += l2.val
                l2 = l2.next
           
            if sum >= 10:
                sum -= 10
                carry = 1
            else:
                carry = 0
            
            temp.next = ListNode(sum)
            temp = temp.next
            
        
        if carry == 1:
            temp.next = ListNode(carry)
        
        
        return result.next
        
        