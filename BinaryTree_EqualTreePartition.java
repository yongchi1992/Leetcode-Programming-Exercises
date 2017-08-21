import java.util.HashMap;

/**
 * Created by yongchizhang on 17/8/20.
 */
public class BinaryTree_EqualTreePartition {
    class Solution {
        HashMap<Integer, Integer> map;

        public boolean checkEqualTree(TreeNode root) {
            map = new HashMap<>();
            int sum = subtreeSum(root);
            if( (sum & 1) != 0){
                return false;
            }
            map.put(sum, map.get(sum) - 1);
            if(map.getOrDefault(sum / 2, 0) > 0){
                return true;
            } else {
                return false;
            }
        }

        public int subtreeSum(TreeNode root){
            if(root == null){
                return 0;
            }
            int res = root.val + subtreeSum(root.left) + subtreeSum(root.right);
            map.put(res, map.getOrDefault(res, 0) + 1);
            return res;
        }
    }
}
