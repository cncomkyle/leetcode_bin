/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode_old(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
    
        ListNode a = headA;
        ListNode b = headB;
    
        //if a & b have different len, then we will stop the loop after second iteration
        while( a != b){
            //for the end of first iteration, we just reset the pointer to the head of another linkedlist
            a = a == null? headB : a.next;
            b = b == null? headA : b.next;
        }
    
        return a;
        
    }

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        //boundary check
        if(headA == null || headB == null) return null;
    
        ListNode a = headA;
        ListNode b = headB;
    
        //if a & b have different len, then we will stop the loop after second iteration
        while(true){
            if(a.val == b.val) {
                return a;
            }
            if(a != null) {
                a = a.next;
            }

            if(b != null) {
                b = b.next;
            }

            if(a == null && b == null) {
                return null;
            }

            if(a == null) {
                a = headB;
            }

            if(b == null) {
                b = headA;
            }
        }
        
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {
            val = x;
            next = null;
        }
    }
    
    public static ListNode createList(int[] nums) {
        if(nums.length == 0) return null;
        ListNode head = new ListNode(nums[0]);
        ListNode preNode = head;
        ListNode newNode = null;
        for(int i=1;i<nums.length;i++) {
            newNode = new ListNode(nums[i]);
            preNode.next = newNode;
            preNode = newNode;
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

    public static void printNode(ListNode node) {
        if(node == null) {
            System.out.println("null");
            return;
        }

        System.out.println(node.val);
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        // printList(createList(new int[]{0, 9, 1, 2, 4}));
        ListNode tmp_1 = ins.getIntersectionNode(createList(new int[]{0, 9, 1, 2, 4}), createList(new int[]{3, 2, 4}));
        printNode(tmp_1);


        ListNode tmp_2 = ins.getIntersectionNode(createList(new int[]{2, 6, 4}), createList(new int[]{1, 5}));
        printNode(tmp_2);
    }
}
