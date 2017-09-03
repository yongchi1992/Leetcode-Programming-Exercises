/**
 * Created by yongchizhang on 9/3/17.
 */
import java.util.*;
public class BinaryTree_SecondMinNode {

    class Solution {
        public int findSecondMinimumValue(TreeNode root) {
            if(root == null){
                return -1;
            }
            Integer min = null, secMin = null;
            Queue<TreeNode> queue = new LinkedList<>();
            queue.offer(root);
            while(!queue.isEmpty()){
                TreeNode tmp = queue.poll();
                if(tmp.left != null){
                    queue.offer(tmp.left);
                }
                if(tmp.right != null){
                    queue.offer(tmp.right);
                }
                int tmpNum = tmp.val;
                if(min == null){
                    min = tmpNum;
                } else if (min > tmpNum){
                    secMin = min;
                    min = tmpNum;
                } else if (min < tmpNum){
                    if(secMin == null){
                        secMin = tmpNum;
                    } else if (secMin > tmpNum){
                        secMin = tmpNum;
                    }
                }
            }
            return secMin == null ? -1 : secMin;
        }
    }

    //这个虽然不是那么好，但用了treeset值得学习
    class Solution_treeset {
        public int findSecondMinimumValue(TreeNode root) {
            TreeSet<Integer> ts = new TreeSet<>();
            go(root, ts);
            if(ts.size() < 2){
                return -1;
            }
            //TreeSet 的方法有  pollFirst  pollLast    first    last
            //这tm的不是比PriorityQueue强多了吗

            ts.pollFirst();

            return ts.first();
        }

        //dfs
        void go(TreeNode node, TreeSet<Integer> ts)
        {
            if(node == null)return;
            ts.add(node.val);
            go(node.left, ts);
            go(node.right, ts);
        }
    }


}
