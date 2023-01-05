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
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> rltList = new ArrayList<>();
        LinkedList<TreeNode> stack = new LinkedList<>();

        TreeNode pNode = root;
        while(pNode != null || !stack.isEmpty()) {
            if(pNode != null) {
                stack.push(pNode);
                pNode = pNode.left;
                
            } else {
                TreeNode tmp = stack.pop();
                rltList.add(tmp.val);
                pNode = tmp.right;
            }
        }

        return rltList;
    }
}
