/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public boolean isValidLeft(TreeNode node, int maxVal) {
        if(node.val >= maxVal) {
            return false;
        }

        if(node.left==null
           &&node.right==null) {
            return true;
        }

       
        if(node.left != null
           && (node.left.val >= node.val)) {
            return false;
        }

        if(node.right != null
           && (node.val >= node.right.val)) {
            return false;
        }
        
        if(node.left != null
           && !isValidLeft(node.left, maxVal)) {
            return false;
        }
        
        if(node.right != null
           && !isValidLeft(node.right, maxVal)) {
            return false;
        }

        return true;
    }


    public boolean isValidRight(TreeNode node, int minVal) {
        if(node.val <= minVal) {
            return false;
        }
        
        if(node.left==null
           &&node.right==null) {
            return true;
        }

        if(node.left != null
           && (node.left.val >= node.val)) {
            return false;
        }

        if(node.right != null
           && (node.val >= node.right.val)) {
            return false;
        }
        
        if(node.left != null
           && !isValidRight(node.left, minVal)) {
            return false;
        }
        
        if(node.right != null
           && !isValidRight(node.right, minVal)) {
            return false;
        }

        return true;
    }
    
    public boolean isValidBST(TreeNode root) {
        if(root == null) {
            return true;
        }

        if(root.left != null
           && (root.left.val >= root.val)) {
            return false;
        }

        if(root.right != null
           && (root.val >= root.right.val)) {
            return false;
        }

        if(root.left != null) {
            if(!isValidLeft(root.left, root.val)) {
                return false;
            }
        }

        if(root.right != null) {
            if(!isValidRight(root.right, root.val)) {
                return false;
            }
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
        Solution692 ins = new Solution692();
        Integer[] nodes = {5,1,4,null,null,3,6};
        System.out.println(ins.isValidBST(ins.createTree(nodes)));

        Integer[] nodes_1 = {2, 1, 3};
        System.out.println(ins.isValidBST(ins.createTree(nodes_1)));

        Integer[] nodes_2 = {};
        System.out.println(ins.isValidBST(ins.createTree(nodes_2)));

        Integer[] nodes_3 = {10,5,15,null,null,6,20};
        System.out.println(ins.isValidBST(ins.createTree(nodes_3)));
    }
}
