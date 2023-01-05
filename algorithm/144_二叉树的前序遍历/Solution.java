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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer> rltList = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode pNode = root;

        while(pNode != null || !stack.isEmpty()) {
            if(pNode != null) {
                rltList.add(pNode.val);
                stack.push(pNode);
                pNode = pNode.left;
            } else {
                pNode = stack.pop().right;
            }
        }
        return rltList;

    }
}
