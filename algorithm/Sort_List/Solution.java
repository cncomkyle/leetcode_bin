import java.util.Stack;
import java.util.List;
import java.util.ArrayList;

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode sortList_old(ListNode head) {
        ListNode newHead = head;
        ListNode newTail = head;
        ListNode trackNode = head.next;
        ListNode checkNode = null;
        while(trackNode != null) {
            checkNode = trackNode;
            trackNode = trackNode.next;

            if(checkNode.val > newTail.val) {
                newTail.next = checkNode;
                checkNode.next = null;
                newTail = checkNode;
                continue;
            }

            if(checkNode.val < newHead.val) {
                checkNode.next = newHead;
                newHead = checkNode;
                continue;
            }

            
        }

        return newHead;
    }

    private class TreeNode {
        ListNode listNode;
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(ListNode node) {listNode = node; val = node.val;}
    }
    public ListNode sortList(ListNode head) {
        if(head == null) return null;
        TreeNode root = new TreeNode(head);
        TreeNode cur = null;
        // create binary tree
        while(head.next != null) {
            head = head.next;

            cur = root;
            while(cur != null) {
                if(head.val < cur.listNode.val) {
                    if(cur.left == null) {
                        cur.left = new TreeNode(head);
                        break;
                    } else {
                        cur = cur.left;
                    }
                } else {
                    if(cur.right == null) {
                        cur.right = new TreeNode(head);
                        break;
                    } else {
                        cur = cur.right;
                    }
                    
                }
            }
        }

        //printTrees(root);

        cur = root;
        Stack<TreeNode> stack = new Stack<>();

        head = null;
        ListNode tmpNode = null;
        while(cur != null ||  stack.size() > 0) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            
            if(head == null) {
                head = cur.listNode;
                tmpNode = head;
            } else {
                tmpNode.next = cur.listNode;
                tmpNode = tmpNode.next;
            }

            cur = cur.right;
        }

        tmpNode.next = null;

        return head;
    }

    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int x) {val = x;}
    }

        public static void printTrees(TreeNode root) {
        List<TreeNode> nodeList = new ArrayList<>();
        List<TreeNode> rltList = new ArrayList<>();
        nodeList.add(root);
        rltList.add(root);
        int size = 0;
        int nodeNum = 0;

        int level = 1;
        int levelNodes = 0;
        while(nodeList.size()>0) {
            if(level > 1) {
                levelNodes = (int)Math.pow(2, level - 1 - 1);

                int beginIndex = levelNodes - 1;

                for(int i=beginIndex;i<=(beginIndex+levelNodes-1);i++) {
                    TreeNode tmpNode = rltList.get(i);
                    if(tmpNode==null) {
                        rltList.add(null);
                        rltList.add(null);
                    } else {
                        if(tmpNode.left != null) {
                            rltList.add(tmpNode.left);
                        } else {
                            rltList.add(null);
                        }

                        if(tmpNode.right != null) {
                            rltList.add(tmpNode.right);
                        } else {
                            rltList.add(null);
                        }
                    }
                }
                
                
            }
            
            size = nodeList.size();

            for(int i=0;i<size;i++) {
                TreeNode tmpNode = nodeList.remove(0);
                if(tmpNode.left != null) {
                    nodeList.add(tmpNode.left);
                }
                if(tmpNode.right != null) {
                    nodeList.add(tmpNode.right);
                }
            }
            level++;

        }

        System.out.printf("[");

        for(int i=rltList.size()-1;i>=0;i--) {
            if(rltList.get(i)==null) {
                rltList.remove(i);
            } else {
                break;
            }
        }
        
        for(TreeNode tmpNode : rltList) {
            if(tmpNode != null) {
                System.out.printf("%d,",tmpNode.val);
            } else {
                System.out.printf("null,");
            }
        }
        System.out.println("]");
    }

    public static ListNode createListNodes(int[] nodes) {
        ListNode head = new ListNode(nodes[0]);
        ListNode cur = head;

        for(int i =1;i<nodes.length;i++) {
            cur.next = new ListNode(nodes[i]);
            cur = cur.next;
        }
        
        return head;
    }

    public static void printListNodes(ListNode head) {
        while(head != null) {
            System.out.printf("%d,", head.val);
            head = head.next;
        }
        System.out.println("");
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();

        int[] nodes_1 = {4, 2, 1, 3};
        //printListNodes(createListNodes(nodes_1));
        printListNodes(ins.sortList(createListNodes(nodes_1)));

        int[] nodes_2 = {-1, 5, 3, 4, 0};
        printListNodes(ins.sortList(createListNodes(nodes_2)));

        int[] nodes_3 = {3, 2, 1};
        printListNodes(ins.sortList(createListNodes(nodes_3)));
    }
}
