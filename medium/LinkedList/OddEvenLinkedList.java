class Solution {
    public ListNode oddEvenList(ListNode head) {
        
        ListNode dummyEven = new ListNode(0);
        ListNode dummyOdd = new ListNode(0);
        ListNode currEven = dummyEven;
        ListNode currOdd = dummyOdd;
        
        ListNode curr = head;
        
        int index = 0;
        while(curr != null) {
            index++;
            
            if(index%2 == 1) {
                currOdd.next = curr;
                currOdd = currOdd.next;
            } else {
                currEven.next = curr;
                currEven = currEven.next;
            }
            curr = curr.next;
        }
        
        currOdd.next = null;
        currEven.next = null;
        
        currOdd.next = dummyEven.next;
        return dummyOdd.next;   
    }
}