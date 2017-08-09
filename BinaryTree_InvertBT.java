/**
 * Created by yongchizhang on 17/8/9.
 */
public class BinaryTree_InvertBT {
    public class Solution {
        public TreeNode invertTree(TreeNode root) {
            if(root == null){
                return root;
            }
            if(root.left == null && root.right == null){
                return root;
            }
            if(root.left == null){
                root.left = invertTree(root.right);
                root.right = null;
            } else if (root.right == null) {
                root.right = invertTree(root.left);
                root.left = null;
            } else {
                TreeNode temp = invertTree(root.left);
                root.left = invertTree(root.right);
                root.right = temp;
            }
            return root;
        }
    }
}
