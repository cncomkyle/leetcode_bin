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
    public int rob(TreeNode root) {
        int[] res = robSub(root);
        return Math.max(res[0], res[1]);
    }

    private int[] robSub(TreeNode root) {
        if (root == null) return new int[2];
    
        int[] left = robSub(root.left);
        int[] right = robSub(root.right);
        int[] res = new int[2];

        res[0] = Math.max(left[0], left[1]) + Math.max(right[0], right[1]);
        res[1] = root.val + left[0] + right[0];
    
        return res;
    }
    public int rob_self(TreeNode root) {
        if(root == null) {
            return 0;
        }
        int level = 0;
        int maxVal = 0;
        List<TreeNode> levelList = new ArrayList<>();
        List<Integer> dps = new ArrayList<>();

        levelList.add(root);
        dps.add(0);
        
        while(levelList.size() > 0) {
            int size = levelList.size();

            int levelSum = 0;
            for(int i=0;i<size;i++) {
                TreeNode tmpNode = levelList.remove(0);
                levelSum += tmpNode.val;
                if(tmpNode.left != null) {
                    levelList.add(tmpNode.left);
                }

                if(tmpNode.right != null) {
                    levelList.add(tmpNode.right);
                }
            }
            level++;
            switch(level) {
            case 1:
            case 2:
                maxVal = Math.max(maxVal, levelSum);
                break;
            default:
                maxVal = Math.max(maxVal, levelSum + dps.get(level - 2));
            }

            
            dps.add(maxVal);
        }

        return maxVal;
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
        System.out.println(ins.rob(createTree(new Integer[]{3,2,3,null,3,null,1})));
        System.out.println(ins.rob(createTree(new Integer[]{3,4,5,1,3,null,1})));
        System.out.println(ins.rob(createTree(new Integer[]{2,1,3,null,4})));

    }
}
