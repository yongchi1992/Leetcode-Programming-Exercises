/**
 * Created by yongchizhang on 17/7/21.
 */
public class BinaryTree_ConstructStringFromBT {

    public class solution_best {
        public String tree2str(TreeNode t) {
            StringBuilder sb = new StringBuilder();
            helper(sb, t);
            return sb.toString();
        }

        public void helper(StringBuilder sb, TreeNode t) {
            if (t != null) {
                sb.append(t.val);
                if (t.left != null || t.right != null) {
                    sb.append("(");
                    helper(sb, t.left);
                    sb.append(")");
                    if (t.right != null) {
                        sb.append("(");
                        helper(sb, t.right);
                        sb.append(")");
                    }
                }
            }
        }
    }

    public class Solution {
        public String tree2str(TreeNode t) {
            if(t == null){
                return "";
            }else if(t.left == null && t.right == null){
                return ""+t.val;
            }else if(t.left == null && t.right != null){
                return t.val + "()" + "(" + tree2str(t.right) + ")";
            }else if(t.left != null && t.right == null){
                return t.val + "(" + tree2str(t.left) + ")";
            }else{
                return t.val + "(" + tree2str(t.left) + ")" + "(" + tree2str(t.right) + ")";
            }

        }
    }
}
