import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yongchizhang on 17/7/28.
 */
public class BinaryTree_SymmetricTree {

    public class Solution {
        boolean result = true;

        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }

            helper(root.left,root.right);
            return result;
        }

        public void helper(TreeNode left, TreeNode right){
            if(!result){
                return;
            }
            if(left == null && right != null){
                result = false;
            }else if(left != null && right == null){
                result = false;
            }else if(left != null && right != null){
                if(left.val != right.val){
                    result = false;
                }else{
                    helper(left.left, right.right);
                    helper(left.right, right.left);
                }
            }

        }
    }



    public class Solution_Queue {

        public boolean isSymmetric(TreeNode root) {
            if(root == null){
                return true;
            }
            Queue<TreeNode> q1 = new LinkedList<>();
            Queue<TreeNode> q2 = new LinkedList<>();
            q1.add(root.left);
            q2.add(root.right);
            while(!q1.isEmpty() || !q2.isEmpty()){
                TreeNode ele1 = q1.poll();
                TreeNode ele2 = q2.poll();
                if(ele1 == null && ele2 == null){
                    continue;
                } else if((ele1 == null && ele2 != null) || (ele1 != null && ele2 == null)){
                    return false;
                } else{
                    if(ele1.val != ele2.val){
                        return false;
                    }else{
                        q1.add(ele1.left);
                        q1.add(ele1.right);
                        q2.add(ele2.right);
                        q2.add(ele2.left);
                    }
                }
            }
            return true;
        }

    }


}
