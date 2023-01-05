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
    // Three static flags to keep track of post-order traversal.

    // Both left and right traversal pending for a node.
    // Indicates the nodes children are yet to be traversed.
    private static int BOTH_PENDING = 2;

    // Left traversal done.
    private static int LEFT_DONE = 1;

    // Both left and right traversal done for a node.
    // Indicates the node can be popped off the stack.
    private static int BOTH_DONE = 0;

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {

        Stack<Pair<TreeNode, Integer>> stack = new Stack<Pair<TreeNode, Integer>>();

        // Initialize the stack with the root node.
        stack.push(new Pair<TreeNode, Integer>(root, Solution692.BOTH_PENDING));

        // This flag is set when either one of p or q is found.
        boolean one_node_found = false;

        // This is used to keep track of the LCA.
        TreeNode LCA = null;

        // Child node
        TreeNode child_node = null;

        // We do a post order traversal of the binary tree using stack
        while (!stack.isEmpty()) {

            Pair<TreeNode, Integer> top = stack.peek();
            TreeNode parent_node = top.getKey();
            int parent_state = top.getValue();

            // If the parent_state is not equal to BOTH_DONE,
            // this means the parent_node can't be popped off yet.
            if (parent_state != Solution692.BOTH_DONE) {

                // If both child traversals are pending
                if (parent_state == Solution692.BOTH_PENDING) {

                    // Check if the current parent_node is either p or q.
                    if (parent_node == p || parent_node == q) {

                        // If one_node_found was set already, this means we have found
                        // both the nodes.
                        if (one_node_found) {
                            return LCA;
                        } else {
                            // Otherwise, set one_node_found to True,
                            // to mark one of p and q is found.
                            one_node_found = true;

                            // Save the current top element of stack as the LCA.
                            LCA = stack.peek().getKey();
                        }
                    }

                    // If both pending, traverse the left child first
                    child_node = parent_node.left;
                } else {
                    // traverse right child
                    child_node = parent_node.right;
                }

                // Update the node state at the top of the stack
                // Since we have visited one more child.
                stack.pop();
                stack.push(new Pair<TreeNode, Integer>(parent_node, parent_state - 1));

                // Add the child node to the stack for traversal.
                if (child_node != null) {
                    stack.push(new Pair<TreeNode, Integer>(child_node, Solution692.BOTH_PENDING));
                }
            } else {

                // If the parent_state of the node is both done,
                // the top node could be popped off the stack.
                // Update the LCA node to be the next top node.
                if (LCA == stack.pop().getKey() && one_node_found) {
                    LCA = stack.peek().getKey();
                }

            }
        }

        return null;
    }

    
    public TreeNode lowestCommonAncestor_old(TreeNode root, TreeNode p, TreeNode q) {
        if(checkReach(p, q)) return p;
        if(checkReach(q, p)) return q;

        if(root.left != null && root.right != null) {
            if(checkReach(root.left, p) && checkReach(root.right, q)) return root;
            if(checkReach(root.left, q) && checkReach(root.right, p)) return root;
        }

        return null;
    }

    public void getParentList(TreeNode root, TreeNode checkNode) {
        Stack<StackNode> stack = new Stack<>();
        StackNode tmpNode = null;
        boolean leftCheck = true;
        boolean finFlg = false;
        while(root != null || stack.size() > 0) {
            leftCheck = true;
            if(root == null
               && stack.size() > 0) {
                while(true) {
                    tmpNode = stack.peek();
                    if(!tmpNode.rightFlag) {
                        root = tmpNode.treeNode;
                        leftCheck = false;

                        break;
                    } else {
                        stack.pop();
                    }
                }
            }
            
            while(root != null && leftCheck) {
                if(root.val == checkNode.val) {
                    finFlg = true;
                    break;
                }
                tmpNode = new StackNode(root);
                System.out.println(root.val);
                stack.push(tmpNode);
                root = root.left;
                tmpNode.leftFlag = true;
            }
            if(finFlg) break;
            tmpNode = stack.peek();
            tmpNode.rightFlag = true;

            root = tmpNode.treeNode;
            root = root.right;
            if(root != null
               && root.val == checkNode.val) {
                break;
            }
        }

        while(stack.size()  > 0) {
            System.out.printf("%d->", stack.pop().treeNode.val);
        }
        
    }

    public class StackNode {
        TreeNode treeNode;
        boolean leftFlag;
        boolean rightFlag;
        StackNode(TreeNode node) {treeNode = node;}
    }

    public boolean checkReach(TreeNode root, TreeNode checkNode) {

        Stack<TreeNode> stack = new Stack<>();
        stack.push(root);
        TreeNode tmpNode = null;
        while(stack.size() > 0) {
            tmpNode = stack.pop();
            
            if(tmpNode.val == checkNode.val) {
                return true;
            }

            if(tmpNode.right != null) {
                stack.push(tmpNode.right);
            }

            if(tmpNode.left != null) {
                stack.push(tmpNode.left);
            }
        }
        
        return false;
    }

    public static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;
        TreeNode(int x) { val = x;}
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
        Integer[] nodes = {1,2,5,3,4,null,6};

        TreeNode root = ins.createTree(nodes);
        ins.getParentList(root, new TreeNode(5));

        Integer[] nodes_1 = {3,5,1,6,2,0,8,null,null,7,4};
        ins.getParentList(ins.createTree(nodes_1), new TreeNode(4));
    }
}
