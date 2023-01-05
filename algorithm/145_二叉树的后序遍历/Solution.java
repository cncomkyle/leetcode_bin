/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<Integer> postorderTraversal(TreeNode root) {
        List<Integer> rltList = new ArrayList<>();

        TreeNode curNode = root;
        
        while(curNode != null) {

            if(curNode.left != null) {
                TreeNode mostRight = curNode.left;
                while(mostRight.right != null && mostRight.right != curNode) {
                    mostRight = mostRight.right;
                }

                if(mostRight.right == null) {
                    mostRight.right = curNode;
                    curNode = curNode.left;
                } else {
                    mostRight.right = null;

                    printRightEdge(curNode.left, rltList);

                    curNode = curNode.right;
                }
                
            } else {
                curNode = curNode.right;
            }
            
        }

        printRightEdge(root, rltList);
        
        return rltList;

    }

    private void printRightEdge(TreeNode root, List<Integer> rltList) {
        TreeNode tail = reverseRightEdge(root);

        TreeNode cur = tail;

        while(cur != null) {
            rltList.add(cur.val);
            cur = cur.right;
        }

        reverseRightEdge(tail);
    }

    private TreeNode reverseRightEdge(TreeNode root) {
        TreeNode pre = null;
        TreeNode next = null;

        while(root != null) {
            next = root.right;
            root.right = pre;

            pre = root;
            root = next;
        }

        return pre;
    }
}
