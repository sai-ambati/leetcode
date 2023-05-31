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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        // int l1value = 0;
        // int l2value = 0;
        // ListNode temp = new ListNode();

        // temp = l1;
        // int mul = 1;
        // while(l1.next != null){
        //     l1value = l1value + l1.val*mul;
        //     l1 = l1.next;
        //     mul *= 10;
        // }
        // l1value = l1value + l1.val*mul; 

        // temp = l2;
        // mul = 1;
        // while(l2.next != null){
        //     l2value = l2value + l2.val*mul;
        //     mul *= 10;
        //     l2 = l2.next;
        // }
        // l2value = l2value + l2.val*mul;


        // int ans = l1value + l2value;


        // System.out.println(l1value);
        // System.out.println(l2value);
        // System.out.println(ans);


        // ListNode head = new ListNode(0);
        // temp = head;

        // if(ans ==0){
        //     return head;
        // }
        // while(ans!=0){
        //     ListNode node = new ListNode(ans%10);
        //     temp.next = node;
        //     temp = temp.next;
        //     ans = ans/10;
        // }

        // return head.next;

        ListNode head = new ListNode(0);
        ListNode temp = head;
        int value;
        int carry = 0;
        while(l1 != null || l2 != null || carry>0){
            value = 0;
            if(l1 != null){
                value += l1.val;
                l1 = l1.next;
            }

            if(l2 != null){
                value += l2.val;
                l2 = l2.next;
            }

            value += carry;

            carry = value/10;
            value = value%10;
            ListNode node = new ListNode(value);
            temp.next = node;
            temp = temp.next;
        }

        return head.next;
    }
}
