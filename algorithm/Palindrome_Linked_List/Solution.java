/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public boolean isPalindrome(ListNode head) {
        if(head == null) return false;

        ListNode slow, fast;

        slow = fast = head;

        while(fast != null && fast.next !=null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        if(fast != null) {
            slow = slow.next;
        }

        // reverse slow
        ListNode nextHead = null;
        ListNode newNext = null;
        while(slow != null) {
            nextHead = slow;
            slow = slow.next;
            nextHead.next = newNext;
            newNext = nextHead;
        }

        slow = nextHead;
        // printList(slow);

        while(slow != null && slow.val == head.val) {
            slow = slow.next;
            head = head.next;
        }

        if(slow != null) return false;

        return true;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public static void printList(ListNode head) {
        while(head != null) {
            System.out.printf("%d,", head.val);
            head = head.next;
        }
        System.out.println("");
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

    public static void main(String[] args) {
        Solution ins = new Solution();

        System.out.println(ins.isPalindrome(createList(new int[]{})));
        System.out.println(ins.isPalindrome(createList(new int[]{1, 2, 2, 1})));
        System.out.println(ins.isPalindrome(createList(new int[]{1, 2})));
        System.out.println(ins.isPalindrome(createList(new int[]{1, 2, 3, 2, 1})));
    }
}
