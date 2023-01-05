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
    public ListNode reverseList(ListNode head) {
        if(head == null) return null;
        
        ListNode preNode = null;
        ListNode newHead = head;
        
        while(head.next != null) {
            head = head.next;
            System.out.println(">>");
            newHead.next = preNode;
            preNode = newHead;
            newHead = head;
        }
        newHead.next = preNode;
        return newHead;
    }

    public void printList(ListNode head) {
        while(head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }

    public static void main(String[] args) {
        Solution tester = new Solution();

        ListNode head = new ListNode(1);
        ListNode preNode  = head;
        for(int i = 2;i<=5;i++) {
            ListNode nextNode = new ListNode(i);
            preNode.next = nextNode;
            preNode = nextNode;
        }
        tester.printList(head);

        System.out.println("##########");
        tester.printList(head);
        System.out.println("##########");

        ListNode newHead = tester.reverseList(head);
        tester.printList(newHead);
    }
}
