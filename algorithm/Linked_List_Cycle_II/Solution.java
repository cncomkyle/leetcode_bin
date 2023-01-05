/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode firstNode, secondNode;

        firstNode = head;
        secondNode = head;

        boolean isCycle = false;
        while(firstNode != null && secondNode != null) {
            firstNode = firstNode.next;
            if(secondNode.next == null) {
                return null;
            }
            secondNode = secondNode.next.next;
            if(firstNode == secondNode) {
                isCycle = true;
                break;
            }
        }

        if(!isCycle)return null;
        firstNode = head;
        while(firstNode != secondNode) {
            firstNode = firstNode.next;
            secondNode = secondNode.next;
        }

        return firstNode;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static void main(String[] args) {
        ListNode node_1 = new ListNode(1);
        ListNode node_2 = new ListNode(2);
        ListNode node_3 = new ListNode(3);
        ListNode node_4 = new ListNode(4);
        ListNode node_5 = new ListNode(5);
        ListNode node_6 = new ListNode(6);
        ListNode node_7 = new ListNode(7);

        node_1.next = node_2;
        node_2.next = node_3;
        node_3.next = node_4;
        node_4.next = node_5;
        node_5.next = node_6;
        node_6.next = node_7;
        node_7.next = node_2;

        Solution692 ins = new Solution692();
        ListNode head = ins.detectCycle(node_1);
        System.out.println(head.val);

    }
}
