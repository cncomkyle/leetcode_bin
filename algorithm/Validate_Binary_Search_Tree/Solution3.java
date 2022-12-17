import java.util.List;
import java.util.ArrayList;
import java.util.Stack;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution3 {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }


    public boolean isValidBST(TreeNode root) {
        if(root==null) {
            return true;
        }
        
        Stack<TreeNode> stack = new Stack<>();

        TreeNode curr = root;
        TreeNode pre = null;
        while(curr != null || !stack.isEmpty()) {
            while(curr != null) {
                stack.push(curr);
                curr = curr.left;
            }
            curr = stack.pop();
            if(pre != null && curr.val <= pre.val) return false;
            pre = curr;
            curr = curr.right;
        }

        
        return true;
    }

    public TreeNode createTree(Integer[] nodes) {
        if(nodes.length==0) {
            return null;
        }
        TreeNode[] nodeArray = new TreeNode[nodes.length];
        for(int i=0;i<nodes.length;i++) {
            if(nodes[i]==null) {
                nodeArray[i] = null;
            } else {
                nodeArray[i] = new TreeNode(nodes[i]);
            }
        }
        for(int i=0;i<nodes.length;i++) {
            if(2*(i+1) > nodes.length) {
                break;
            }
            if(nodeArray[2*(i+1) - 1] != null) {
                nodeArray[i].left = nodeArray[2*(i+1) - 1];
            }
            if(nodeArray[2*(i+1)] != null) {
                nodeArray[i].right= nodeArray[2*(i+1)];
            }
        }

        return nodeArray[0];
    }

    public static void main(String[] args) {
        Solution3 ins = new Solution3();
        Integer[] nodes = {5,1,4,null,null,3,6};
        System.out.println(ins.isValidBST(ins.createTree(nodes)));

        Integer[] nodes_1 = {2, 1, 3};
        System.out.println(ins.isValidBST(ins.createTree(nodes_1)));

        Integer[] nodes_2 = {};
        System.out.println(ins.isValidBST(ins.createTree(nodes_2)));

        Integer[] nodes_3 = {10,5,15,null,null,6,20};
        System.out.println(ins.isValidBST(ins.createTree(nodes_3)));

        Integer[] nodes_4 = {24,-60,null,-60,-6};
        System.out.println(ins.isValidBST(ins.createTree(nodes_4)));

    }
}
