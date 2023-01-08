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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if(list1 == null) {
            return list2;
        } else if (list2 == null) {
            return list1;
        }
        
        ListNode head = list1;
        if(list1.val >= list2.val) {
            head = list2;
            list2 = list2.next;
        } else {
            head = list1;
            list1 = list1.next;
        }
        ListNode preNode = head;
        
        while(list1 != null && list2 != null) {

            if(list1.val <= list2.val) {
                preNode.next = list1;
                preNode = list1;
                list1 = list1.next;
            } else {
                preNode.next = list2;
                preNode = list2;
                list2 = list2.next;
            }

        }

        if(list1 != null) {
            preNode.next = list1;
        }

        if(list2 != null) {
            preNode.next = list2;
        }
        
        return head;
    }

    public void printList(ListNode head) {
        while(head != null) {
            System.out.printf("%d ->", head.val);
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Solution tester = new Solution();

        ListNode list1 = new ListNode(1);
        // ListNode tmp = list1;
        // ListNode newNode = new ListNode(2);
        // tmp.next = newNode;
        // tmp = newNode;

        // newNode = new ListNode(4);
        // tmp.next = newNode;
        // tmp = newNode;

        ListNode list2 = new ListNode(2);
        // tmp = list2;
        // newNode = new ListNode(3);
        // tmp.next = newNode;
        // tmp = newNode;

        // newNode = new ListNode(4);
        // tmp.next = newNode;
        // tmp = newNode;

        tester.printList(list1);
        tester.printList(list2);
        
        ListNode head = tester.mergeTwoLists(list1, list2);
        tester.printList(head);

    }
}
