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
    
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode newHead = null;
        if(lists.length ==  0) {
            return null;
        }
        if(lists.length == 1) {
            return lists[0];
        }
        newHead = mergeTwoLists(lists[0], lists[1]);

        for(int i=2;i<lists.length;i++) {
            newHead = mergeTwoLists(newHead, lists[i]);
        }

        return newHead;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};
        ListNode rlt = ins.mergeKLists(lists);

        while(rlt != null) {
            System.out.printf("%d->", rlt.val);
            rlt = rlt.next;
        }
    }
}
