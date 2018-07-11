/**
 * Definition for binary tree
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
//深度优先搜索
public class Solution {
    public int run(TreeNode root) {
        if(root == null){
            return 0;
        }
        
        int left = run(root.left);
        int right = run(root.right);
        
        return (left == 0 || right == 0) ? (left + right + 1) : Math.min(left,right)+1;
    }
}