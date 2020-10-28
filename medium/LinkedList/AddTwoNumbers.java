class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        
        int carry = 0, term = 0;
        
        while(l1 != null || l2 != null) {
            int val1 = (l1 == null)? 0 : l1.val;
            int val2 = (l2 == null)? 0 : l2.val;
            
            int sum = val1 + val2 + carry;
            carry = sum/10;
            term = sum%10;
            
            curr.next = new ListNode(term);
            curr = curr.next;
            
            if(l1 != null) l1 = l1.next; 
            if(l2 != null) l2 = l2.next;
        }
        
        if(carry > 0) curr.next = new ListNode(carry);
        
        return dummy.next;
    }
}