/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode oddEvenList(ListNode head) {
        ListNode prevOdd=null;
        ListNode prevEven=null;
        ListNode headOfEven=null;
        ListNode current=head;
        
        int count=1;
        while(current!=null){
            if((count%2)==0){
                if(prevEven==null){
                    headOfEven=current;
                }
                else{
                   prevEven.next=current; 
                }
                prevEven=current;
            }
            else{
                if(prevOdd!=null){
                    prevOdd.next=current;
                }
                 prevOdd=current;
            }  
            current=current.next;
            count++;
        }
        
        if(prevOdd!=null)
            prevOdd.next=headOfEven;
         if(prevEven!=null)
            prevEven.next=null;
        return head;
    }
}