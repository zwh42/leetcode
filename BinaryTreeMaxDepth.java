/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class BinaryTreeMaxDepth{
    public int maxDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        else if (root.left == null && root.right == null){
            return 1;
        }else {
            return maxDepth(root.left) > maxDepth(root.right) ? 1 + maxDepth(root.left) : maxDepth(root.right);
        }
    }
}