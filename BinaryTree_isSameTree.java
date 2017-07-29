/**
 * Created by yongchizhang on 17/7/21.
 */
public class BinaryTree_isSameTree {
    public class Solution {
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
