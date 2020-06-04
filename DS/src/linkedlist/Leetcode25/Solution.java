package linkedlist.Leetcode25;

 class ListNode {
      int val;
      ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }

class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        if(head==null)
            return null;
        int totalCount=totalCount(head,k);
        if(totalCount<k)
            return head;
        
        ListNode current=head;
        ListNode prev=null;
        int count=1;
        while(count<=k && current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
            count++;
        }
        
        if(current!=null){
            head.next=reverseKGroup(current,k);
        }    
        return prev;
    
    }
    
    
    private int totalCount(ListNode node,int k){
        ListNode current=node;
        int totalCount=0;
        while(current!=null && totalCount<=k){
            current=current.next;
            totalCount++;
        }
        return totalCount;
    }
}