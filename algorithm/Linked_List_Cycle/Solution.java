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
    public boolean hasCycle(ListNode head) {
        ListNode nextNode = null;
        ListNode next2Node = null;

        nextNode = head;
        next2Node = head;

        while(nextNode != null && next2Node != null) {
            nextNode = nextNode.next;
            if(next2Node.next != null) {
                next2Node = next2Node.next.next;
            } else {
                return false;
            }

            if(next2Node == nextNode) {
                return true;
            }
        }

        return false;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }

    public static ListNode createList(int[] nums, int pos) {
        if(nums.length == 0) {
            return null;
        }

        ListNode preNode = null;
        ListNode rootNode = new ListNode(nums[0]);
        preNode = rootNode;

        ListNode tailNode = null;
        if(pos == 0) {
            tailNode = rootNode;
        }
        for(int i=1;i<nums.length;i++) {
            ListNode newNode = new ListNode(nums[i]);
            preNode.next = newNode;
            preNode = newNode;

            if(i==pos) {
                tailNode = newNode;
            }
                
        }

        if(tailNode != null) {
            preNode.next = tailNode;
        }
        
        return rootNode;
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        System.out.println(ins.hasCycle(createList(new int[]{3,2,0,-4}, 1)));
        System.out.println(ins.hasCycle(createList(new int[]{1, 2}, 0)));
        System.out.println(ins.hasCycle(createList(new int[]{1}, -1)));
        System.out.println(ins.hasCycle(createList(new int[]{1, 2, 3, 4}, -1)));
    }
}
