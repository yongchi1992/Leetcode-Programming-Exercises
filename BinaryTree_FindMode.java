import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * Created by yongchizhang on 17/7/28.
 */
public class BinaryTree_FindMode {

    // 想要int是个null？ 用Integer类！！   很明显是中序遍历
    public class Solution_best {
        Integer prev = null;
        int count = 1;
        int max = 0;
        public int[] findMode(TreeNode root) {
            if (root == null) return new int[0];

            List<Integer> list = new ArrayList<>();
            traverse(root, list);

            int[] res = new int[list.size()];
            for (int i = 0; i < list.size(); ++i) res[i] = list.get(i);
            return res;
        }

        private void traverse(TreeNode root, List<Integer> list) {
            if (root == null) return;
            traverse(root.left, list);
            if (prev != null) {
                if (root.val == prev)
                    count++;
                else
                    count = 1;
            }
            if (count > max) {
                max = count;
                list.clear();
                list.add(root.val);
            } else if (count == max) {
                list.add(root.val);
            }
            prev = root.val;
            traverse(root.right, list);
        }
    }




    //  更简单的方法是用map，不过这道题理应是可以O(1) Space 的
    public class Solution {
        int max = 1;
        int count = 1;
        int before;

        public int[] findMode(TreeNode root) {
            if(root == null){
                return new int[0];
            }
            LinkedList<Integer> list = new LinkedList<>();
            before = root.val + 1;
            helper(root, list);
            int[] result = new int[list.size()];
            int i = 0;
            for(int num: list){
                result[i] = num;
                i++;
            }
            return result;
        }

        public void helper(TreeNode root, LinkedList<Integer> list){
            if(root.left != null){
                helper(root.left, list);
            }
            if(root.val != before){
                count = 1;
                if(count == max){
                    list.add(root.val);
                }
                before = root.val;
            }else{
                count++;
                if(count > max){
                    list.clear();
                    list.add(root.val);
                    max = count;
                }else if(count == max){
                    list.add(root.val);
                }
            }
            if(root.right != null){
                helper(root.right, list);
            }
        }
    }



}
