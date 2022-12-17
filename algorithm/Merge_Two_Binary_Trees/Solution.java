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
public class Solution {
    public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
        if (t1 == null)
            return t2;
        Stack < TreeNode[] > stack = new Stack < > ();
        stack.push(new TreeNode[] {t1, t2});
        while (!stack.isEmpty()) {
            TreeNode[] t = stack.pop();
            if (t[0] == null || t[1] == null) {
                continue;
            }
            t[0].val += t[1].val;
            if (t[0].left == null) {
                t[0].left = t[1].left;
            } else {
                stack.push(new TreeNode[] {t[0].left, t[1].left});
            }
            if (t[0].right == null) {
                t[0].right = t[1].right;
            } else {
                stack.push(new TreeNode[] {t[0].right, t[1].right});
            }
        }
        return t1;
    }

    public TreeNode cloneTree(TreeNode root) {
        if(root == null) return null;
        TreeNode newRoot = new TreeNode(root.val);
        List<TreeNode> srcList = new ArrayList<>();
        List<TreeNode> newList = new ArrayList<>();
        srcList.add(root);
        newList.add(newRoot);
        TreeNode srcNode;
        TreeNode newNode;
        TreeNode tmpNode;
        while(srcList.size() > 0) {
            int tmp = srcList.size();
            for(int i=0;i<tmp;i++) {
                srcNode = srcList.remove(0);
                newNode = newList.remove(0);

                if(srcNode.left != null) {
                    tmpNode = new TreeNode(srcNode.left.val);
                    newNode.left = tmpNode;

                    srcList.add(srcNode.left);
                    newList.add(tmpNode);
                }

                if(srcNode.right != null) {
                    tmpNode = new TreeNode(srcNode.right.val);
                    newNode.right = tmpNode;

                    srcList.add(srcNode.right);
                    newList.add(tmpNode);
                }
            }
        }

        return newRoot;
    }
    
    public TreeNode mergeTrees_self(TreeNode t1, TreeNode t2) {
        if(t1 == null && t2 == null) {
            return null;
        }

        if(t1 == null && t2 != null) {
            return t2;
        }

        if(t1 != null && t2 == null) {
            return t1;
        }
        TreeNode newRoot = new TreeNode(t1.val + t2.val);
        TreeNode nullNode = new TreeNode(0);

        List<TreeNode> t1List = new ArrayList<>();
        List<TreeNode> t2List = new ArrayList<>();
        List<TreeNode> newList = new ArrayList<>();

        t1List.add(t1);
        t2List.add(t2);
        newList.add(newRoot);
        
        TreeNode t1Node = null;
        TreeNode t2Node = null;
        TreeNode newNode = null;
        TreeNode tmpNode = null;
        TreeNode t1Left = null;
        TreeNode t1Right = null;
        TreeNode t2Left = null;
        TreeNode t2Right = null;
        
        while(t1List.size() > 0 && t2List.size() > 0) {
            int size_1 = t1List.size();
            int size_2 = t2List.size();

            for(int i=0;i<size_1;i++) {
                t1Node = t1List.remove(0);
                t2Node = t2List.remove(0);
                newNode = newList.remove(0);

                if(t1Node == nullNode && t2Node == nullNode && newNode == nullNode) {
                    continue;
                }

                if(t1Node.left != null || t2Node.left != null) {
                    t1Left = t1Node.left == null ? nullNode : t1Node.left;
                    t2Left = t2Node.left == null ? nullNode : t2Node.left;
                    tmpNode = new TreeNode(t1Left.val + t2Left.val);
                    newNode.left = tmpNode;
                    newList.add(tmpNode);
                    t1List.add(t1Left);
                    t2List.add(t2Left);
                }


                if(t1Node.right != null || t2Node.right != null) {
                    t1Right = t1Node.right == null ? nullNode : t1Node.right;
                    t2Right = t2Node.right == null ? nullNode : t2Node.right;
                    tmpNode = new TreeNode(t1Right.val + t2Right.val);
                    newNode.right = tmpNode;
                    newList.add(tmpNode);
                    t1List.add(t1Right);
                    t2List.add(t2Right);
                }


            }
        }
        
        return newRoot;
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

        printTrees(ins.mergeTrees(createTree(new Integer[]{1, 3, 2, 5}), createTree(new Integer[]{2, 1, 3, null, 4, null, 7})));
        printTrees(ins.cloneTree(createTree(new Integer[]{1, 3, 2, 5})));

    }
}
