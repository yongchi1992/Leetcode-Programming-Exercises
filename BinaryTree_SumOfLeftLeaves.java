/**
 * Created by yongchizhang on 17/7/21.
 */
public class BinaryTree_SumOfLeftLeaves {
    public class Solution {
        public int sumOfLeftLeaves(TreeNode root) {
            if(root == null){
                return 0;
            }
            return helper(root, false);
        }
        public int helper(TreeNode root, boolean isLeft){
            if(root.left == null && root.right == null){
                return isLeft ? root.val : 0;
            }
            int sum = 0;
            if(root.left != null){
                sum += helper(root.left, true);
            }
            if(root.right != null){
                sum += helper(root.right, false);
            }
            return sum;
        }
    }
}
