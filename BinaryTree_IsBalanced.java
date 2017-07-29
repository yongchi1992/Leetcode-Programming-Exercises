/**
 * Created by yongchizhang on 17/7/10.
 */
public class BinaryTree_IsBalanced {
    public class Solution {
        public boolean isBalanced(TreeNode root) {
            if(root == null){
                return true;
            }
            return treedepth(root, 1) != -1;
        }

        public int treedepth(TreeNode root, int current){
            if(root == null){
                return 0;
            }
            if(current == -1){
                return -1;
            }
            int left = treedepth(root.left, current + 1);
            int right = treedepth(root.right, current + 1);
            if(left == -1 || right == -1 || Math.abs(left - right) > 1){
                return -1;
            }

            return Math.max(left, right) + 1;
        }
    }



    public class Solution2 {

        class ResultType{
            public int depth;
            public boolean isBalanced;
            public ResultType(int depth, boolean isBalanced){
                this.depth = depth;
                this.isBalanced = isBalanced;
            }
            public ResultType(){
                this.depth = 0;
                this.isBalanced = true;
            }
        }

        public boolean isBalanced(TreeNode root) {
            return treedepth(root).isBalanced;
        }

        public ResultType treedepth(TreeNode root){
            if(root == null){
                return new ResultType(0, true);
            }
            ResultType result = new ResultType();
            ResultType left = treedepth(root.left);
            ResultType right = treedepth(root.right);
            result.depth = Math.max(left.depth, right.depth) + 1;
            result.isBalanced = left.isBalanced & right.isBalanced;
            if(Math.abs(left.depth - right.depth) > 1){
                result.isBalanced = false;
            }
            return result;
        }
    }



}
