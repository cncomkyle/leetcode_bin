/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head, tail;
        ListNode zeroNode = new ListNode(0);
        ListNode add1 = l1;
        ListNode add2 = l2;
        
        int nextAddition = 0;
        int newVal = 0;

        head = tail = new ListNode(0);
        while(true) {
            
            newVal = add1.val + add2.val + nextAddition;
            nextAddition = newVal / 10;
            newVal = newVal % 10;

            tail.next = new ListNode(newVal);
            tail = tail.next;

            add1 = add1.next == null ? zeroNode : add1.next;
            add2 = add2.next == null ? zeroNode : add2.next;

            if(add1  == zeroNode
               && add2 == zeroNode
               && nextAddition == 0) {
                break;
            }
        }

        return head.next;
}
