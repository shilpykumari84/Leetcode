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
class Solution {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        // Base Case 1: Both nodes are null -> Trees are identical up to this point
        if (p == null && q == null) {
            return true;
        }
        
        // Base Case 2: One node is null and the other is not -> Trees are structurally different
        if (p == null || q == null) {
            return false;
        }
        
        // Base Case 3: The values of the current nodes do not match
        if (p.val != q.val) {
            return false;
        }
        
        // Recursively check if left subtrees match AND right subtrees match
        return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}
