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
class Solution {
    public int maxDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int result = 0;
        List<TreeNode> list = new ArrayList<>();
        list.add(root);

        TreeNode tmpNode = null;
        while(true) {
            int size = list.size();
            if(size == 0) {
                break;
            }
            result++;
            for(int i=0;i<size;i++) {
                tmpNode = list.remove(0);

                if(tmpNode.left != null) {
                    list.add(tmpNode.left);
                }

                if(tmpNode.right != null) {
                    list.add(tmpNode.right);
                }
            }
        }

        return result;
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

        System.out.println(ins.maxDepth(createTree(new Integer[]{1,2,2,3,4,4,3})));

        System.out.println(ins.maxDepth(createTree(new Integer[]{1,2,2,null,3,null,3})));

        System.out.println(ins.maxDepth(createTree(new Integer[]{3,9,20,null,null,15,7})));
    }
}
