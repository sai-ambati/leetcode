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
    public ListNode partition(ListNode head, int x) {
        
        ListNode left = new ListNode();
        ListNode right = new ListNode();
        ListNode l = left;
        ListNode r = right;
        ListNode temp = head;
        
        while (temp != null) {
            if (temp.val < x) {
                left.next = temp;
                left = left.next;
            }
            else {
                right.next = temp;
                right = right.next;
            }
            temp = temp.next;
        }
        right.next = null;
        left.next = r.next;
        return l.next;
    }
}
