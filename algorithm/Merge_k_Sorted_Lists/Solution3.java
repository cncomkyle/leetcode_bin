/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
       public ListNode mergeKLists(ListNode[] lists) {
        if(lists.length==0)
            return null;
        return merge(0,lists.length-1,lists);
    }
    public ListNode merge(int i,int j,ListNode[] lists) {
        if(j<i)return null;
        if(i==j)return lists[i];
        int mid=i+(j-i)/2;
        ListNode l=merge(i,mid,lists);
        ListNode r= merge(mid+1,j,lists);
        ListNode dummy =new ListNode(0);
        ListNode runner= dummy;

        while(l!=null && r!=null) {
            if(l.val>r.val) {
                runner.next=r;
                r=r.next;
                runner=runner.next;
            }
            else {
                runner.next=l;
                l=l.next;
                runner=runner.next;
            }
        }
        if(l==null && r==null)
            return dummy.next;
        if(l==null)
            runner.next=r;
        else
            runner.next=l;
        return dummy.next;
    }
}
