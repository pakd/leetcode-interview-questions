public class Solution {
    
    int length(ListNode head) {
        int count = 0;  
        while(head != null) {
            count++;
            head = head.next;
        }
        return count;
    }
    
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        // Length of  A should be greater than B
        if(length(headA) < length(headB)) {
            return getIntersectionNode(headB, headA);
        }
                
        int aLength = length(headA);
        int bLength = length(headB);
        
        int diff = aLength - bLength;
        
        // skip in first list by diff
        ListNode curr = headA;
        for(int i=0; i<diff; i++) {
            curr = curr.next;
        }
        
        while(curr != null && headB != null) {
            if(curr == headB) return curr;
            curr = curr.next;
            headB = headB.next;
        }
        
        return null;    
    }
}