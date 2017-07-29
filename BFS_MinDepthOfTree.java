import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by yongchizhang on 17/7/27.
 */
public class BFS_MinDepthOfTree {
    /**
     * Definition for a binary tree node.
     * public class TreeNode {
     *     int val;
     *     TreeNode left;
     *     TreeNode right;
     *     TreeNode(int x) { val = x; }
     * }
     */
    public class Solution {
        class datatype{

            TreeNode node;
            int num;
            datatype(TreeNode no, int n){
                num = n;
                node = no;
            }
        }
        public int minDepth(TreeNode root) {
            if(root == null){
                return 0;
            }
            Queue<datatype> queue = new LinkedList<>();
            queue.add(new datatype(root, 1));
            while(!queue.isEmpty()){
                datatype temp = queue.poll();
                if(temp.node.left == null && temp.node.right == null){
                    return temp.num;
                }
                if(temp.node.left != null)
                    queue.add(new datatype(temp.node.left, temp.num + 1));
                if(temp.node.right != null)
                    queue.add(new datatype(temp.node.right, temp.num + 1));
            }
            return 0;
        }
    }
}
