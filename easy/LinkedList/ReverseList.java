class Solution {
    
    ListNode modifiedHead;
    
    private void recursiveReverseList(ListNode p) {
        if(p.next == null) {
            modifiedHead = p;
            return;
        }

        recursiveReverseList(p.next);
        
        ListNode q = p.next;
        q.next = p;
        p.next = null;
    }

    public ListNode reverseList(ListNode head) {
        if(head == null) return head;
        recursiveReverseList(head);
        return modifiedHead;
    }
}