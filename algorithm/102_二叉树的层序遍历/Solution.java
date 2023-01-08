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
    public List<List<Integer>> levelOrder_old(TreeNode root) {
        List<List<Integer>> rltList = new ArrayList<>();
        if(root == null) {
            return rltList;
        }

        Deque<TreeNode> dequeue = new ArrayDeque<>();
        dequeue.offer(root);

        
        while(!dequeue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int checkCnt =  dequeue.size();
            for(int i=0;i<checkCnt;i++) {
                TreeNode tmpNode = dequeue.poll();

                levelList.add(tmpNode.val);
                if(tmpNode.left != null) {
                    dequeue.offer(tmpNode.left);
                }

                if(tmpNode.right != null) {
                    dequeue.offer(tmpNode.right);
                }
            }
            rltList.add(levelList);
        }
        
        return rltList;
    }



    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> rltList = new ArrayList<>();
        if(root == null) {
            return rltList;
        }
        int height = 0;
        int levelCnt = 1;

        Deque<TreeNode> dequeue = new ArrayDeque<>();
        dequeue.offer(root);

        
        while(!dequeue.isEmpty()) {
            List<Integer> levelList = new ArrayList<>();
            int checkCnt = Math.min(levelCnt, dequeue.size());
            for(int i=0;i<checkCnt;i++) {
                TreeNode tmpNode = dequeue.poll();
                if(tmpNode == null) {
                    break;
                }
                levelList.add(tmpNode.val);
                if(tmpNode.left != null) {
                    dequeue.offer(tmpNode.left);
                }

                if(tmpNode.right != null) {
                    dequeue.offer(tmpNode.right);
                }
            }
            rltList.add(levelList);
            height++;
            levelCnt = levelCnt * 2;
        }
        
        return rltList;
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

        for(int i=0;i<array.length;i++) {
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

    public void printTree(TreeNode root) {
        if(root==null) return;
        System.out.println(root.val);
        printTree(root.left);
        printTree(root.right);
        
    }

    public static void main(String[] args) {
        Solution tester = new Solution();
        TreeNode node = tester.array2Tree(new Integer[]{1,2,null,3,null,4,null,5});
        tester.printTree(node);
        List<List<Integer>> rltList = tester.levelOrder(node);

        for(List<Integer> levelList : rltList) {
            levelList.stream().forEach(a -> System.out.printf("%d,",a));
            System.out.println("");
        }
        
        
    }
}
