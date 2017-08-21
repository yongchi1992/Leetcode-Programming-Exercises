import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yongchizhang on 17/8/20.
 */
public class BinaryTree_MaximumWidth {
    class Solution {
        class NodeLoc{
            TreeNode n;
            long loc;
            NodeLoc(TreeNode n, long loc){
                this.n = n;
                this.loc = loc;

            }
        }
        public int widthOfBinaryTree(TreeNode root) {
            if(root == null){
                return 0;
            }
            Queue<NodeLoc> queue = new LinkedList<>();

            queue.offer(new NodeLoc(root, 1));
            int max = 1;

            //int offset = 0;

            while(!queue.isEmpty()){

                long floor_min = Long.MAX_VALUE, floor_max = 0;

                int size = queue.size();
                for(int i = 0; i < size; i++){

                    NodeLoc temp = queue.poll();
                    TreeNode tmp = temp.n;
                    long loc = temp.loc;

                    if(i == 0){
                        floor_min = loc;
                    }

                    if(i == size - 1){
                        floor_max = loc;
                    }

                    if(size == 1){
                        loc = 1;
                    }

                    if(tmp.left != null){
                        queue.offer(new NodeLoc(tmp.left, 2 * loc - 1));
                    }
                    if(tmp.right != null){
                        queue.offer(new NodeLoc(tmp.right, 2 * loc));
                    }
                }

                max = Math.max((int)(floor_max - floor_min + 1), max);
            }
            return max;
        }
    }
}
