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
    public boolean isSubtree(TreeNode s, TreeNode t) {
        return traverse(s,t);
    }
    public boolean equals(TreeNode x,TreeNode y)
    {
        if(x==null && y==null)
            return true;
        if(x==null || y==null)
            return false;
        return x.val==y.val && equals(x.left,y.left) && equals(x.right,y.right);
    }
    public boolean traverse(TreeNode s,TreeNode t)
    {
        return  s!=null && ( equals(s,t) || traverse(s.left,t) || traverse(s.right,t));
    }

    
    public boolean isSubtree_self(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }

        if(!(s != null && t != null)) {
            return false;
        }

        List<TreeNode> levelList = new ArrayList<>();
        levelList.add(s);
        TreeNode tmpNode;
        while(levelList.size() > 0) {
            int tmp = levelList.size();
            for(int i=0;i<tmp;i++) {
                tmpNode = levelList.remove(0);

                if(tmpNode.val == t.val) {
                    if(isSameTree(tmpNode, t)) {
                        return true;
                    }
                }

                if(tmpNode.left != null) {
                    levelList.add(tmpNode.left);
                }

                if(tmpNode.right != null) {
                    levelList.add(tmpNode.right);
                }
            }
        }

        return false;
    }

    public boolean compareNodes(TreeNode s, TreeNode t) {
        if(s == null && t == null) {
            return true;
        }

        if(s != null && t != null && s.val == t.val) {
            return true;
        }

        return false;
    }

    public boolean isSameTree(TreeNode s, TreeNode t) {
        List<TreeNode> sList = new ArrayList<>();
        List<TreeNode> tList = new ArrayList<>();

        sList.add(s);
        tList.add(t);

        while(sList.size() > 0
              && sList.size() == tList.size()) {

            int tmp = sList.size();
            for(int i=0;i<tmp;i++) {
                s = sList.remove(0);
                t = tList.remove(0);

                if(!compareNodes(s.left, t.left)) {
                    return false;
                }

                if(!compareNodes(s.right, t.right)) {
                    return false;
                }

                if(s.left != null) {
                    sList.add(s.left);
                    tList.add(t.left);
                }

                if(s.right != null) {
                    sList.add(s.right);
                    tList.add(t.right);
                }
                
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

        System.out.println(ins.isSubtree(createTree(new Integer[]{3, 4, 5, 1, 2}), createTree(new Integer[]{4, 1, 2})));

        System.out.println(ins.isSubtree(createTree(new Integer[]{3, 4, 5, 1, 2, null, null, null, null, 0}), createTree(new Integer[]{4, 1, 2})));

        System.out.println(ins.isSubtree(createTree(new Integer[]{-1,-4,8,-6,-2,3,9,null,-5,null,null,0,7}), createTree(new Integer[]{3, 0, 5848})));
                           
                           
    }
    
}

