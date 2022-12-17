import java.util.Map;
import java.util.HashMap;
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

    class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) {val = x;}
    }

    public TreeNode buildTreeNode(int[] preorder, int[] inorder, int preBegin, int preEnd, int inBegin, int inEnd, Map<Integer, Integer> preMap, Map<Integer, Integer> inMap) {
        int rootVal = preorder[preBegin];
        TreeNode rootNode = new TreeNode(rootVal);

        int rootInIndex = inMap.get(rootVal);

        int newPreLeftBegin = -1;
        int newPreLeftEnd = -1;
        int newInLeftBegin = -1;
        int newInLeftEnd = -1;


        int newPreRightBegin = -1;
        int newPreRightEnd = -1;
        int newInRightBegin = -1;
        int newInRightEnd = -1;

        if(rootInIndex - 1 >= inBegin) {
            newInLeftEnd = rootInIndex - 1;
            newInLeftBegin = inBegin;

            newPreLeftEnd = preMap.get(inorder[newInLeftEnd]);
            newPreLeftBegin = preBegin + 1;

            if(newPreLeftBegin + (newInLeftEnd - newInLeftBegin + 1) <= preEnd) {
                newPreRightBegin = newPreLeftBegin + (newInLeftEnd - newInLeftBegin + 1);
                newPreRightEnd = preEnd;

                newInRightBegin = rootInIndex + 1;
                newInRightEnd = inEnd;
            }

            rootNode.left = buildTreeNode(preorder, inorder, newPreLeftBegin, newPreLeftEnd, newInLeftBegin, newInLeftEnd, preMap, inMap);
        } else {
            newPreRightBegin = preBegin + 1;

            if(newPreRightBegin <= preEnd) {
                newPreRightEnd = preEnd;

                newInRightBegin = inBegin + 1;
                newInRightEnd = inEnd;

                
            }
        }

        if(newPreRightBegin >0 && newPreRightEnd > 0) {
            rootNode.right = buildTreeNode(preorder, inorder, newPreRightBegin, newPreRightEnd, newInRightBegin, newInRightEnd, preMap, inMap);
        }

        return rootNode;
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if(preorder.length == 0
           || inorder.length == 0) {
            return null;
        }
        
        Map<Integer, Integer> preMap = new HashMap<>();
        Map<Integer, Integer> inMap = new HashMap<>();

        for(int i=0;i<preorder.length;i++) {
            preMap.put(preorder[i],i);
        }

        for(int i=0;i<inorder.length;i++) {
            inMap.put(inorder[i],i);
        }
        return buildTreeNode(preorder, inorder, 0, preorder.length -1 , 0, inorder.length - 1, preMap, inMap);
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

    public static void main(String[] args) {
        Solution ins = new Solution();
        int[] preorder = {3, 9, 20, 15, 7};
        int[] inorder = {9, 3, 15, 20, 7};

        TreeNode rootNode = ins.buildTree(preorder, inorder);
        printTrees(rootNode);

        int[] preorder_1 = {1, 2, 3};
        int[] inorder_1 = {3, 2, 1};

        TreeNode rootNode_1 = ins.buildTree(preorder_1, inorder_1);
        printTrees(rootNode_1);

        int[] preorder_2 = {3,2,1,6,4,5};
        int[] inorder_2 = {1,2,3,4,5,6};

        TreeNode rootNode_2 = ins.buildTree(preorder_2, inorder_2);
        printTrees(rootNode_2);
    }
}
