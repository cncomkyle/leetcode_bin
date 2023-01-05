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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rltList = new ArrayList<>();
        if(root == null) {
            return rltList;
        }
        List<TreeNode> nodeList = new ArrayList<>();
        nodeList.add(root);
        int size = 0;
        while(nodeList.size()>0) {
            size = nodeList.size();

            List<Integer> levelNodes = new ArrayList<>();
            for(int i=0;i<size;i++) {
                TreeNode tmpNode = nodeList.remove(0);
                levelNodes.add(tmpNode.val);
                if(tmpNode.left != null) {
                    nodeList.add(tmpNode.left);
                }
                if(tmpNode.right != null) {
                    nodeList.add(tmpNode.right);
                }
            }
            rltList.add(levelNodes);
        }
        return rltList;
    }

    private class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
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

    public static void printList(List<List<Integer>> rltList) {
        for(List<Integer> levelList : rltList) {
            for(Integer tmpVal : levelList) {
                System.out.printf("%d,",tmpVal);
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        Solution692 ins = new Solution692();
        Integer[] nodes = {5,1,4,null,null,3,6};

        List<List<Integer>> rltList = ins.levelOrder(ins.createTree(nodes));
        printList(rltList);

    }
}
