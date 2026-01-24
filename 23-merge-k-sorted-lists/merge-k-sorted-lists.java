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
import java.util.PriorityQueue;

class Solution {
    //New submission
    public ListNode mergeKLists(ListNode[] lists) {
        // Handle edge cases: if input is null or empty
        if (lists == null || lists.length == 0) return null;

        // 1. Initialize the PriorityQueue (Min-Heap)
        // Fixed spelling: PriorityQueue
        PriorityQueue<ListNode> queue = new PriorityQueue<>((a, b) -> a.val - b.val);

        // 2. Add the head of each list to the queue
        for (ListNode node : lists) {
            if (node != null) {
                queue.add(node);
            }
        }

        // 3. Setup the Anchor (dummy) and the Builder (curr)
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;

        // 4. The main loop: merge nodes from the heap
        while (!queue.isEmpty()) {
            ListNode smallest = queue.poll();
            
            curr.next = smallest; // Wire the node
            curr = curr.next;     // Move the builder forward
            
            // If the list we just pulled from has more nodes, add the next one
            if (smallest.next != null) {
                queue.add(smallest.next);
            }
        }

        return dummy.next;
    }
}