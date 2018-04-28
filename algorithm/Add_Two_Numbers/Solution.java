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
        ListNode head = null;
        ListNode tail = null;
        ListNode nextNode = null;
        ListNode newNode = null;
        
        int nextAddition = 0;
        int newVal = 0;
        
        
        while(true) {
            newVal = l1.val + l2.val + nextAddition;
            if(newVal >= 10) {
                newVal = newVal - 10;
                nextAddition = 1;
            } else {
                nextAddition = 0;
            }
            newNode = new ListNode(newVal);
            if(head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }

            if(l1.next == null
               || l2.next == null) {
                if(l1.next != null) {
                    nextNode = l1.next;
                } else if(l2.next != null) {
                    nextNode = l2.next;
                }
                break;
            }
            l1 = l1.next;
            l2 = l2.next;
        }

        if(nextNode != null) {
            
            while(true) {
                // if(nextAddition == 0) {
                //     tail.next = nextNode;
                //     break;
                // }
                
                newVal = nextNode.val + nextAddition;
                if(newVal >= 10) {
                    newVal = newVal - 10;
                    nextAddition = 1;
                } else {
                    nextAddition = 0;
                }

                newNode = new ListNode(newVal);
                tail.next = newNode;
                tail = newNode;
                if(nextNode.next == null) {
                    break;
                }
                nextNode = nextNode.next;
            }
        }

        if(nextAddition == 1) {
            newNode = new ListNode(nextAddition);
            tail.next = newNode;
            tail = newNode;
        }

        return head;
    }
}
