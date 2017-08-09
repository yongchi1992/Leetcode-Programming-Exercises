/**
 * Created by yongchizhang on 17/8/9.
 */
import java.util.*;
public class BFS_LargestNumInEachRow {
    public class Solution {
        public List<Integer> largestValues(TreeNode root) {
            List<Integer> res = new LinkedList<>();
            if(root == null){
                return res;
            }
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                int size = queue.size();
                int max = Integer.MIN_VALUE;
                for(int i = 0; i < size; i++){
                    TreeNode temp = queue.poll();
                    if(temp.val > max){
                        max = temp.val;
                    }
                    if(temp.left != null){
                        queue.offer(temp.left);
                    }
                    if(temp.right != null){
                        queue.offer(temp.right);
                    }

                }
                res.add(max);
            }
            return res;
        }
    }
}
