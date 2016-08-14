import java.util.LinkedList;
import java.util.Queue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BinaryTree{
   
    public static TreeNode buildTree(TreeNode root, int[] nums, int index){
        if(index >= nums.length){
            return null;
        }
        root = new TreeNode(nums[index]);
        root.left = buildTree(root.left, nums, 2 * index + 1);
        root.right = buildTree(root.right, nums, 2 * index + 2);
        return root;
    }

    
    public static int countNodes(TreeNode root){
        if (root == null){
            return 0;
        }else{
            return (1 + countNodes(root.left) + countNodes(root.right));
        }
    }


    public static void main(String[] args){
        int[] nums= {0,1,2,3,4,5,6,7,8,9,10};

        TreeNode root = null;        
        root = buildTree(root, nums, 0);
        BTreePrinter.printNode(root);
    }
    
}

class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode(int x) { val = x; }
 }


class BTreePrinter { 
	 
    public static <T extends Comparable<?>> void printNode(TreeNode root) {
        int maxLevel = BTreePrinter.maxLevel(root);
 
        printNodeInternal(Collections.singletonList(root), 1, maxLevel);
    } 
 
    private static <T extends Comparable<?>> void printNodeInternal(List<TreeNode> nodes, int level, int maxLevel) {
        if (nodes.isEmpty() || BTreePrinter.isAllElementsNull(nodes))
            return; 
 
        int floor = maxLevel - level;
        int endgeLines = (int) Math.pow(2, (Math.max(floor - 1, 0)));
        int firstSpaces = (int) Math.pow(2, (floor)) - 1;
        int betweenSpaces = (int) Math.pow(2, (floor + 1)) - 1;
 
        BTreePrinter.printWhitespaces(firstSpaces);
 
        List<TreeNode> newNodes = new ArrayList<TreeNode>();
        for (TreeNode node : nodes) {
            if (node != null) {
                System.out.print(node.val);
                newNodes.add(node.left);
                newNodes.add(node.right);
            } else { 
                newNodes.add(null);
                newNodes.add(null);
                System.out.print(" ");
            } 
 
            BTreePrinter.printWhitespaces(betweenSpaces);
        } 
        System.out.println("");
 
        for (int i = 1; i <= endgeLines; i++) {
            for (int j = 0; j < nodes.size(); j++) {
                BTreePrinter.printWhitespaces(firstSpaces - i);
                if (nodes.get(j) == null) {
                    BTreePrinter.printWhitespaces(endgeLines + endgeLines + i + 1);
                    continue; 
                } 
 
                if (nodes.get(j).left != null)
                    System.out.print("/");
                else 
                    BTreePrinter.printWhitespaces(1); 
 
                BTreePrinter.printWhitespaces(i + i - 1);
 
                if (nodes.get(j).right != null)
                    System.out.print("\\");
                else 
                    BTreePrinter.printWhitespaces(1); 
 
                BTreePrinter.printWhitespaces(endgeLines + endgeLines - i);
            } 
 
            System.out.println("");
        } 
 
        printNodeInternal(newNodes, level + 1, maxLevel);
    } 
 
    private static void printWhitespaces(int count) {
        for (int i = 0; i < count; i++)
            System.out.print(" ");
    } 
 
    private static <T extends Comparable<?>> int maxLevel(TreeNode node) {
        if (node == null)
            return 0; 
 
        return Math.max(BTreePrinter.maxLevel(node.left), BTreePrinter.maxLevel(node.right)) + 1;
    } 
 
    private static <T> boolean isAllElementsNull(List<T> list) {
        for (Object object : list) {
            if (object != null)
                return false; 
        } 
 
        return true; 
    } 
 
} 


