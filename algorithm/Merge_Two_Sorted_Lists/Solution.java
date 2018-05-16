/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }
    
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode head = null, tmpNode = null, nextNode = null;
        
        while(l1 != null
              && l2 != null) {
            if(l1.val <= l2.val) {
                tmpNode = l1;
                l1 = l1.next;
            } else {
                tmpNode = l2;
                l2 = l2.next;
            }
            
            if(head == null) {
                head = tmpNode;
                nextNode = head;
            } else {
                nextNode.next = tmpNode;
                nextNode = tmpNode;
            }

        }

        tmpNode = null;
        if(l1 != null) {

            tmpNode = l1;
        } else if(l2 != null) {
            tmpNode = l2;

        }
        if(nextNode == null) {
            head = tmpNode;
        } else {
            nextNode.next = tmpNode;
        }
        return head;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        ListNode head1 = new ListNode(1);
        head1.next = new ListNode(2);
        head1.next.next = new ListNode(4);
        head1.next.next.next = new ListNode(5);

        ListNode head2 = new ListNode(1);
        head2.next = new ListNode(3);
        head2.next.next = new ListNode(4);
        head2.next.next.next = new ListNode(5);

        ListNode result = ins.mergeTwoLists(head1, head2);
        while(result != null) {
            System.out.printf("%d->", result.val);
            result = result.next;
        }
    }
}
