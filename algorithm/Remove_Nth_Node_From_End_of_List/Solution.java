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
    
    public ListNode removeNthFromEnd(ListNode head, int n) {
        if(head == null) {
            return null;
        }
        ListNode newHead = head;
        ListNode tmpNode = null, nextNode = head;
        int count=0;
        while(nextNode != null) {
            count++;
            if(count  == (n+1)) {
                if(tmpNode == null) {
                    tmpNode = head;
                } else {
                    tmpNode = tmpNode.next;                    
                }

                count--;
            }
            nextNode = nextNode.next;
        }
        
        if(tmpNode == null) {
            newHead = newHead.next;
        } else {
            tmpNode.next = tmpNode.next.next;
        }
        
        return newHead;
    }

    public static void main(String[] args) {
        Solution ins = new Solution();
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);
        ListNode result = ins.removeNthFromEnd(head, 2);
        // ListNode result = head;
        while(result != null) {
            System.out.printf("%d->",result.val);
            result = result.next;
        }
    }
}
