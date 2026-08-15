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
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<TreeNode> generateTrees(int n) {
        if (n == 0) {
            return new ArrayList<>();
        }
        return buildTrees(1, n);
    }

    private List<TreeNode> buildTrees(int start, int end) {
        List<TreeNode> allTrees = new ArrayList<>();
        
        // Base case: if start > end, no nodes can be formed, return a list containing null
        if (start > end) {
            allTrees.add(null);
            return allTrees;
        }

        // Iterate through all values from start to end to pick each as the root
        for (int i = start; i <= end; i++) {
            // Generate all possible left subtrees
            List<TreeNode> leftTrees = buildTrees(start, i - 1);
            
            // Generate all possible right subtrees
            List<TreeNode> rightTrees = buildTrees(i + 1, end);

            // Connect the root node 'i' with all combinations of left and right subtrees
            for (TreeNode left : leftTrees) {
                for (TreeNode right : rightTrees) {
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    allTrees.add(root);
                }
            }
        }
        
        return allTrees;
    }
}
