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
    public TreeNode invertTree(TreeNode root) {
        if(root == null) {
            return null;
        }
        List<TreeNode> levelList = new ArrayList<>();

        levelList.add(root);
        TreeNode tmpNode = null;
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        while(levelList.size() > 0) {
            int tmpNum = levelList.size();
            for(int i=0;i<tmpNum;i++) {
                tmpNode = levelList.remove(0);
                leftNode = tmpNode.left;
                rightNode = tmpNode.right;
                
                if(rightNode != null) {
                    levelList.add(rightNode);
                }
                tmpNode.left = rightNode;

                if(leftNode != null) {
                    levelList.add(leftNode);
                }
                tmpNode.right = leftNode;
            }
        }

        return root;
    }


    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
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
            if((2*(i+1) < nodes.length) && nodeArray[2*(i+1)] != null) {
                nodeArray[i].right= nodeArray[2*(i+1)];
            }
        }

        return nodeArray[0];
    }


    public static void main(String[] args) {
        Solution ins = new Solution();

        printTrees(ins.invertTree(createTree(new Integer[]{4, 2, 7, 1, 3, 6, 9})));
        printTrees(ins.invertTree(createTree(new Integer[]{1, 2})));
    }
}
