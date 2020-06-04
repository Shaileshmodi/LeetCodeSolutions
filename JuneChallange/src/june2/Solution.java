package june2;

/**
 * @author shailesh.modi
 * @version 1.0.0
 * @since 6/4/2020
 */

  class ListNode {
    int val;
     ListNode next;
     ListNode(int x) { val = x; }
}

class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev=node;
        prev.val=node.next.val;
        prev.next=node.next.next;
    }
}