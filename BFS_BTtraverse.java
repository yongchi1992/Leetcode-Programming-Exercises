/**
 * Created by yongchizhang on 17/8/9.
 */
import java.util.*;
public class BFS_BTtraverse {
    public class Solution {
        public List<List<Integer>> levelOrderBottom(TreeNode root) {
            List<List<Integer>> res = new LinkedList<>();
            if(root == null){
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                List<Integer> elem = new LinkedList<>();
                for(int i = 0; i < size; i++){
                    TreeNode temp = queue.poll();
                    if(temp.left != null){
                        queue.offer(temp.left);
                    }
                    if(temp.right != null){
                        queue.offer(temp.right);
                    }
                    elem.add(temp.val);
                }
                res.add(0, elem);
            }
            return res;
        }
    }
}
