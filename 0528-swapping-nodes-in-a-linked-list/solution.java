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
    public ListNode swapNodes(ListNode head, int k) {
        ListNode node=head;
        int count=0;
        while(node.next!=null)
        {
            count++;
            node=node.next;
        }
        node =head;        
        ListNode temp=head;
        for(int i=0;i<k-1;i++)
            node=node.next;
        
        for(int i=0;i<=count-k;i++)
            temp=temp.next;
            
        int tempn=node.val;
        node.val=temp.val;
        temp.val=tempn;
        return head;
    }

}
