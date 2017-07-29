import java.util.Stack;

/**
 * Created by yongchizhang on 17/7/12.
 */
public class BinaryTree_FlattenBinaryTree {

    public class Solution {
        private TreeNode current = null;

        public void flatten(TreeNode root) {
            if(root == null){
                return;
            }

            if(current == null){
                current = root;
            }

            TreeNode left = root.left;
            TreeNode right = root.right;

            if(left != null){
                current.left = null;
                current.right = left;
                current = current.right;
                flatten(left);
            }

            if(right != null){
                current.left = null;
                current.right = right;
                current = current.right;
                flatten(right);
            }


        }



    }



    public class Solution2 {
        public void flatten(TreeNode root) {
            helper(root);
        }

        public TreeNode helper(TreeNode root){
            if(root == null){
                return null;
            }

            TreeNode left = helper(root.left);
            TreeNode right = helper(root.right);

            if(left == null && right == null){
                return root;
            }

            if(left == null){
                return right;
            }

            if(right == null){
                root.right = root.left;
                root.left = null;
                return left;
            }

            left.right = root.right;
            root.right = root.left;
            root.left = null;
            return right;

        }
    }


    public class Solution3 {
        public void flatten(TreeNode root) {
            if(root == null){
                return;
            }
            Stack<TreeNode> stack =new Stack<>();
            TreeNode current = root;
            if(root.right != null){
                stack.push(root.right);
            }
            if(root.left != null){
                stack.push(root.left);
            }
            while(!stack.isEmpty()){
                current.left = null;
                current.right = stack.pop();

                if(current.right.right != null){
                    stack.push(current.right.right);
                }
                if(current.right.left != null){
                    stack.push(current.right.left);
                }

                current = current.right;

            }
        }
    }
}
