/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public ListNode reverseList_iterate(ListNode head) {
        ListNode nextHead = null;

        ListNode newNext = null;

        while(head != null) {
            nextHead = head;
            head = head.next;
            nextHead.next = newNext;
            newNext = nextHead;
        }

        return nextHead;
    }

    

    public ListNode reverseList(ListNode head) {
        if(head == null || head.next == null) return head;
        
        ListNode newHead = reverseList(head.next);
        head.next.next = head;
        head.next = null;
        return newHead;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static ListNode createList(int[] nums) {
        if(nums.length == 0) {
            return null;
        }

        ListNode head = new ListNode(nums[0]);
        ListNode preNode = head;

        for(int i=1;i<nums.length;i++) {
            ListNode tmpNode = new ListNode(nums[i]);
            preNode.next = tmpNode;
            preNode = tmpNode;
        }

        return head;
    }

    public static void printList(ListNode head) {
        while(head != null) {
            System.out.printf("%d,", head.val);
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        ListNode head_1 = createList(new int[]{1, 2, 3, 4, 5});
        printList(ins.reverseList(head_1));

        ListNode head_2 = createList(new int[]{5, 4, 3, 2, 1});
        printList(ins.reverseList(head_2));
    }
}
