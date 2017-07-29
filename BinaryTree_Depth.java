/**
 * Created by yongchizhang on 17/7/10.
 */
import java.math.*;
public class BinaryTree_Depth {

    public class Solution {
        public int maxDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            return Math.max(maxDepth(root.left) , maxDepth(root.right)) + 1;
        }
    }


    public class Solution2{
        private int depth;

        public int maxDepth(TreeNode root){
            depth = 0;
            helper(root, 1);

            return depth;
        }

        private void helper(TreeNode node, int curtDepth){
            if(node == null){
                return;
            }
            if(curtDepth > depth){
                depth = curtDepth;
            }
            helper(node.left, curtDepth + 1);
            helper(node.right, curtDepth + 1);
        }
    }
}
