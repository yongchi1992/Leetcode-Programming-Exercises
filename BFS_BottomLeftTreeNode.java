import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yongchizhang on 17/8/9.
 */
public class BFS_BottomLeftTreeNode {
    public class Solution {
        public int findBottomLeftValue(TreeNode root) {
            int res = 0;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                for(int i = 0; i < size; i++){
                    TreeNode temp = queue.poll();
                    if(temp.left != null){
                        queue.offer(temp.left);
                    }
                    if(temp.right != null){
                        queue.offer(temp.right);
                    }
                    if(i == 0){
                        res = temp.val;
                    }
                }
            }
            return res;
        }
    }
}
