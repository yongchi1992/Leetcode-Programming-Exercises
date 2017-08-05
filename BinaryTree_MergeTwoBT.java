/**
 * Created by yongchizhang on 17/8/4.
 */
public class BinaryTree_MergeTwoBT {
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
        public TreeNode mergeTrees(TreeNode t1, TreeNode t2) {
            TreeNode t;
            if (t1 == null && t2 != null){
                t = t2;
            } else if (t1 != null && t2 == null) {
                t = t1;
            } else if (t1 != null && t2 != null) {
                t = new TreeNode(t1.val + t2.val);
                t.left = mergeTrees(t1.left, t2.left);
                t.right = mergeTrees(t1.right, t2.right);
            } else {
                return null;
            }
            return t;
        }
    }
}
