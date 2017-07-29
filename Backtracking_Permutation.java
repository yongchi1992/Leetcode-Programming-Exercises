/**
 * Created by yongchizhang on 17/7/6.
 */
import java.util.*;
public class Backtracking_Permutation {
    public class Solution {
        public List<List<Integer>> permute(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            helper(result, new LinkedList<Integer>(), new boolean[nums.length], nums, nums.length);
            return result;
        }
        public void helper(List<List<Integer>> result, List<Integer> element, boolean[] used, int[] nums, int n){
            if(n == 0){
                result.add(new LinkedList<Integer>(element));
                return;
            }
            for(int i = 0; i < nums.length; i++){
                if(used[i] == false){
                    used[i] = true;
                    element.add(nums[i]);
                    helper(result, element, used, nums, n - 1);
                    used[i] = false;
                    element.remove(element.size() - 1);
                }
            }
        }
    }
}
