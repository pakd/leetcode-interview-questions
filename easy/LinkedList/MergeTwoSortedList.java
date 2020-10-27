class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode dummy = new ListNode(0);
        ListNode tail = dummy;
        
        ListNode curr1 = l1;
        ListNode curr2 = l2;
        
        while(curr1 != null || curr2 != null) {
            int val1 = (curr1 != null)? curr1.val: Integer.MAX_VALUE;
            int val2 = (curr2 != null)? curr2.val: Integer.MAX_VALUE;
            
            if(val1 < val2) {
                tail.next = curr1;
                curr1 = curr1.next;
            } else {
                tail.next = curr2;
                curr2 = curr2.next;
            }
            tail = tail.next;
            
        }
        
        return dummy.next;
    }
}