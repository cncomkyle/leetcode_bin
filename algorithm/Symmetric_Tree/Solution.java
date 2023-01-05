import java.util.List;
import java.util.ArrayList;

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
    public boolean isSymmetric(TreeNode root) {
        if(root == null) {
            return true;
        }
        TreeNode leftNode = root.left;
        TreeNode rightNode = root.right;

        if(leftNode == null && rightNode == null) {
            return true;
        }

        if(!(leftNode != null && rightNode != null)) {
            return false;
        } 

        if(leftNode.val != rightNode.val) {
            return false;
        }

        List<TreeNode> leftList = new ArrayList<>();
        List<TreeNode> rightList = new ArrayList<>();
        leftList.add(leftNode);
        rightList.add(rightNode);
        
        int nextLevel = 1;
        TreeNode leftCheckLeft = null;
        TreeNode leftCheckRight = null;
        TreeNode rightCheckLeft = null;
        TreeNode rightCheckRight = null;
        while(leftList.size() > 0 && rightList.size() > 0) {
            leftNode = leftList.remove(0);
            rightNode = rightList.remove(0);

            leftCheckLeft = leftNode.left;
            leftCheckRight = leftNode.right;

            rightCheckLeft = rightNode.left;
            rightCheckRight = rightNode.right;

            if(leftCheckLeft == null && rightCheckRight !=null) {
                return false;
            }

            if(leftCheckLeft != null && rightCheckRight ==null) {
                return false;
            }

            if(leftCheckLeft != null && rightCheckRight != null) {
                if(leftCheckLeft.val != rightCheckRight.val) {
                    return false;
                }
                leftList.add(leftCheckLeft);
                rightList.add(rightCheckRight);
            }

            if(leftCheckRight == null && rightCheckLeft !=null) {
                return false;
            }

            if(leftCheckRight != null && rightCheckLeft ==null) {
                return false;
            }

            if(leftCheckRight != null && rightCheckLeft != null) {
                if(leftCheckRight.val != rightCheckLeft.val) {
                    return false;
                }
                leftList.add(leftCheckRight);
                rightList.add(rightCheckLeft);
            }
            
        }

        return true;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public static TreeNode createTree(Integer[] nodes) {
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

        System.out.println(ins.isSymmetric(createTree(new Integer[]{1,2,2,3,4,4,3})));

        System.out.println(ins.isSymmetric(createTree(new Integer[]{1,2,2,null,3,null,3})));
    }
}
