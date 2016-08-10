/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTreeMaxDepth{
    public static int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        else if (root.left == null && root.right == null){
            System.out.println("return 1");
            return 1;
        }else {
            return maxDepth(root.left) > maxDepth(root.right) ? 1 + maxDepth(root.left) :  1 + maxDepth(root.right);
        }
    }
    
    public static int maxDepth2(TreeNode root){
        Queue<TreeNode> q = new LinkedList();
        if (root == null){
            return 0;
        }
        q.add(root);
        int height = 0;  
        while(q.size() != 0){
            int currentLevelNodeCount = q.size();
            height++;         
            while(currentLevelNodeCount > 0){
                TreeNode node = q.peek();
                q.remove();
                if(node.left != null){
                    q.add(node.left);
                }
                if(node.right != null){
                    q.add(node.right);
                }                
                currentLevelNodeCount--;
            }     
        }
        return height;
    }
    
   
    
    
    public static void main(String[] args){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        
        /*
        root.left.left = new TreeNode(1);
        root.left.left.left = new TreeNode(1);
        root.left.left.left.left = new TreeNode(1);
        */
        
        System.out.println("1. max depth = " + maxDepth(root)); //should be 4
        System.out.println("2. max depth = " + maxDepth2(root)); //should be 4
    }
}


 class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }