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

     class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

public class Solution {

    public ListNode reverseKGroup(ListNode head, int k) {
        if(k <= 1) {
            return head;
        }
        int count = 1;
        ListNode start = head, end = head, preEnd = null, newHead = null;
        
        while(true) {
            end = end.next;
            if(end == null) {
                if(preEnd != null) {
                    preEnd.next = start;
                }
                break;
            }
            count++;
            if(count == k) {
                ListNode nextStart = end.next;
                ListNode tmpHead = revertList(start, end);

                if(newHead == null) {
                    newHead = tmpHead;
                }
                                        
                if(preEnd != null) {
                    preEnd.next = tmpHead;
                }
                if(nextStart == null) {
                    break;
                }
                preEnd = start;
                start = nextStart;
                end = start;
                count = 1;
            } 
        }
        return newHead;
    }

    public ListNode revertList(ListNode start, ListNode end) {
        ListNode pre = start;
        ListNode next = start.next;

        while(true) {
            ListNode tmp = next.next;
            //            System.out.println(">>" + pre.val);
            next.next = pre;
            pre = next;
            next = tmp;

            if(pre==end) {
                break;
            }
        }
        start.next = null;
        return end;
    }

    public void printNodeList(ListNode head) {
        while(head != null) {
            System.out.printf("%d ->", head.val);
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Solution tester = new Solution();

        ListNode head = new ListNode(1);
        ListNode cur = head;
        for(int i=2;i<=2;i++) {
            ListNode tmpNode = new ListNode(i);
            cur.next = tmpNode;
            cur = cur.next;
        }

        tester.printNodeList(head);

        ListNode newHead = tester.reverseKGroup(head, 2);
        tester.printNodeList(newHead);

        // ListNode newHead = tester.revertList(head, cur);
        // tester.printNodeList(newHead);
    }
}
