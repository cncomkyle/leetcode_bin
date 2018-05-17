class Solution1 {
    static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

    public ListNode mergeKLists(ListNode[] lists) {
        ListNode head = null, nextNode = null;
        int checkCnt = lists.length;
        int index = -1;
        int minVal = 0;


        for(int i =0;i<lists.length;i++) {
            if(lists[i] == null) {
                checkCnt--;
            }
        }
        while(checkCnt > 1) {
            minVal = 0;
            index = -1;
            for(int i=0;i<lists.length;i++) {
                if(lists[i] == null) {

                    continue;
                }

                if(index < 0
                   || minVal > lists[i].val) {
                    minVal = lists[i].val;
                    index = i;
                }
            }

            if(index < 0) {
                return null;
            }

            if(head == null) {
                head = lists[index];
                nextNode = head;
            } else {
                nextNode.next = lists[index];
                nextNode = nextNode.next;
            }

            lists[index] = lists[index].next;
            if(lists[index] == null) {
                checkCnt--;
            }

        }

        for(int i =0;i<lists.length;i++) {
            if(lists[i]!=null) {
                if(nextNode == null) {
                    head = lists[i];
                } else {
                    nextNode.next = lists[i];
                }
                break;
            }
        }

        return head;
    }

    public static void main(String[] args) {
        Solution1 ins = new Solution1();

        ListNode l1 = new ListNode(1);
        l1.next = new ListNode(4);
        l1.next.next = new ListNode(5);

        ListNode l2 = new ListNode(1);
        l2.next = new ListNode(3);
        l2.next.next = new ListNode(4);

        ListNode l3 = new ListNode(2);
        l3.next = new ListNode(6);

        ListNode[] lists = {l1, l2, l3};

        ListNode l4 = new ListNode(-1);
        l4.next = new ListNode(5);
        l4.next.next = new ListNode(11);

        ListNode l5 = new ListNode(6);
        l5.next = new ListNode(11);

        ListNode[] lists_1 = {null, l4, null, l5};
        
        // ListNode rlt = ins.mergeKLists(lists);
        
        ListNode rlt = ins.mergeKLists(lists_1);

        while(rlt != null) {
            System.out.printf("%d->", rlt.val);
            rlt = rlt.next;
        }
    }
    
}
