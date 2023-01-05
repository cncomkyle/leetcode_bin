import java.util.List;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

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
    public int pathSum_old(TreeNode root, int sum) {
        if(root == null) {
            return 0;
        }

        int result = 0;
        Map<TreeNode, List<Integer>> nodeMap = new HashMap<>();
        List<TreeNode> levelList = new ArrayList<>();

        levelList.add(root);
        List<Integer> rootList = new ArrayList<>();
        rootList.add(root.val);
        nodeMap.put(root, rootList);
        if(root.val == sum) {
            result++;
        }

        TreeNode tmpNode = null;
        TreeNode leftNode = null;
        TreeNode rightNode = null;
        int newVal;
        while(levelList.size() > 0) {
            int num = levelList.size();
            for(int i=0;i<num;i++) {
                tmpNode = levelList.remove(0);

                leftNode = tmpNode.left;
                rightNode = tmpNode.right;

                if(leftNode != null) {
                    List<Integer> leftList = new ArrayList<>();
                    for(Integer tmpVal : nodeMap.get(tmpNode)) {
                        newVal = tmpVal + leftNode.val;
                        leftList.add(newVal);
                        if(newVal == sum) {
                            result++;
                        }
                    }

                    leftList.add(leftNode.val);
                    if(leftNode.val == sum) {
                        result++;
                    }
                    nodeMap.put(leftNode, leftList);
                    levelList.add(leftNode);
                }


                if(rightNode != null) {
                    List<Integer> rightList = new ArrayList<>();
                    for(Integer tmpVal : nodeMap.get(tmpNode)) {
                        newVal = tmpVal + rightNode.val;
                        rightList.add(newVal);
                        if(newVal == sum) {
                            result++;
                        }
                    }

                    rightList.add(rightNode.val);
                    if(rightNode.val == sum) {
                        result++;
                    }
                    nodeMap.put(rightNode, rightList);
                    levelList.add(rightNode);
                }
            }
        }

        return result;
    }


    public int pathSum(TreeNode root, int sum) {
        Map<Integer, Integer> preSumMap = new HashMap<>();
        preSumMap.put(0, 1);

        return helper(root, 0, sum, preSumMap);
    }

    public int helper(TreeNode root, int currentSum, int sum, Map<Integer, Integer> preSumMap) {
        if(root == null) {
            return 0;
        }

        currentSum += root.val;
        int res = preSumMap.getOrDefault(currentSum - sum, 0);
        preSumMap.put(currentSum, preSumMap.getOrDefault(currentSum, 0) + 1);

        res += helper(root.left, currentSum, sum, preSumMap) + helper(root.right, currentSum, sum, preSumMap);
        preSumMap.put(currentSum, preSumMap.get(currentSum) - 1);
        return res;
        
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
        Solution692 ins = new Solution692();

        System.out.println(ins.pathSum(createTree(new Integer[]{10,5,-3,3,2,null,11,3,-2,null,1}), 8));
    }
}
