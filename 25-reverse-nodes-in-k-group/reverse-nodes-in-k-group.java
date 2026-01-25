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
    // Lookup to see if there are atleast k
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode node = head ; 
        for (int i = 0; i < k ; i ++){
            if (node == null) return head;
            node = node.next;
        }
        //Reverse the current group of k
        ListNode newHead = reverse(head,node);
        // Call next group recursively
        head.next = reverseKGroup(node , k);
        return newHead;

}
    private ListNode reverse(ListNode head , ListNode stop){
        ListNode prev = null ; 
        ListNode curr = head ; 
        while (curr != stop){
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev ; 
    }
}