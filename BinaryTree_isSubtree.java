/**
 * Created by yongchizhang on 17/7/21.
 */
public class BinaryTree_isSubtree {



    public class Solution {
        public boolean isSubtree(TreeNode s, TreeNode t) {
            if(isSameTree(s, t)){
                return true;
            }
            if(s.left != null && isSubtree(s.left, t)){
                return true;
            }
            if(s.right != null && isSubtree(s.right, t)){
                return true;
            }
            return false;
        }


        public boolean isSameTree(TreeNode p, TreeNode q) {
            if((p == null && q != null) ||(p != null && q == null)){
                return false;
            }else if(p == null && q == null){
                return true;
            }
            if(p.val != q.val){
                return false;
            }
            if(!isSameTree(p.left, q.left)){
                return false;
            }
            if(!isSameTree(p.right, q.right)){
                return false;
            }
            return true;
        }

    }
}
