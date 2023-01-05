/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
import java.util.*;

 class TreeNode {
     int val;
     TreeNode left;
     TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }


public class Solution {

    
    public TreeNode increasingBST(TreeNode root) {
        LinkedList<TreeNode> stack = new LinkedList<>();
        TreeNode newRoot = null;
        TreeNode newPreNode = null;
        while(root != null || stack.size() > 0) {
            if(root != null) {
                stack.push(root);
                root = root.left;
            } else {
                root = stack.pop();
                if(newRoot == null) {
                    newRoot = root;
                } else{
                    newPreNode.right = root;
                }
                newPreNode = root;
                newPreNode.left = null;

                root = root.right;
            }
        }
        return newRoot;
    }

    public TreeNode increasingBST_new(TreeNode root) {
        TreeNode head = null, tail = null;
        Deque<TreeNode> stack = new ArrayDeque<>();

        TreeNode cur = root;

        while(!stack.isEmpty() || cur != null) {
            while(cur != null) {
                stack.push(cur);
                cur = cur.left;
            }

            cur = stack.pop();
            if(head == null) {
                head = cur;
            } else {
                tail.right = cur;
            }

            tail = cur;
            cur.left = null;

            cur = cur.right;
        }
        return head;
    }


    public TreeNode array2Tree(Integer[] array) {
        TreeNode root = null;
        Map<Integer, TreeNode> nodeMap = new HashMap<>();
        for(int i =0;i<array.length;i++) {
            if(array[i] == null) {
                nodeMap.put(i+1, null);
                continue;
            }
            TreeNode newNode = new TreeNode();
            newNode.val = array[i];
            nodeMap.put(i+1, newNode);
        }

        for(int i=0;i<array.length && (2 * (i + 1) <= array.length);i++) {
            if(nodeMap.get(i+1) == null) {
                continue;
            }
            TreeNode node = nodeMap.get(i+1);
            // left
            TreeNode leftN = nodeMap.get(2 * (i+1));
            if(leftN != null) {
                node.left = leftN;
            }
            // right
            TreeNode rightN = nodeMap.get(2 * (i+1) + 1);
            if (rightN != null) {
                node.right = rightN;
            }
        }

        return nodeMap.get(1);
    }

    public Integer[] Tree2Array(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        LinkedList<TreeNode> queue = new LinkedList<>();
        TreeNode nullNode = new TreeNode();
        nullNode.val = -1;
        queue.offer(root);
        while(queue.size() > 0) {
            int size = queue.size();
            for(int i=0;i<size;i++) {
                root = queue.poll();
                list.add(root);
                if(root.val < 0) continue;
                
                if(root.left != null) {
                    queue.offer(root.left);
                } else {
                    if(i != size-1) {
                        queue.offer(nullNode);
                    }
                }

                if(root.right != null) {
                    queue.offer(root.right);
                } else {
                    if(i != size -1) {
                        queue.offer(nullNode);
                    }
                }
                
            }
        }
        Integer[] rltArray = new Integer[list.size()];

        int index = 0;
        for(TreeNode tmpNode : list) {
            if(tmpNode.val >= 0) {
                rltArray[index] = tmpNode.val;
            } else {
                rltArray[index] = null;
            }
            index++;
        }
        return rltArray;

    }

    public void printTree(TreeNode root) {
        if(root==null) return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
        
    }

    public static void main(String[] args) {
        Solution tester = new Solution();
        TreeNode node = tester.array2Tree(new Integer[]{2, 1, 4, null, null, 3});
        Integer[] newArray = tester.Tree2Array(node);
        tester.printTree(node);
        TreeNode newNode = tester.increasingBST(node);
        tester.printTree(newNode);



        for(Integer ele : newArray) {
            System.out.printf("%s,", ele != null ? ele: "null");
        }
        System.out.println("");

    }
}
