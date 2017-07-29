import java.util.*;

/**
 * Created by yongchizhang on 17/7/5.
 */
public class Backtracking_Subsets {
    public class Solution {
        public List<List<Integer>> subsets(int[] nums) {

            List<List<Integer>> result = new LinkedList<>();
            if(nums == null || nums.length == 0){
                return result;
            }
            List<Integer> element = new LinkedList<>();
            helper(result, element, nums, 0);
            return result;
        }
        public void helper(List<List<Integer>> result, List<Integer> element, int[] nums, int index){
            result.add(new LinkedList<Integer>(element));
            for(int i = index; i < nums.length; i++){
                element.add(nums[i]);
                helper(result, element, nums, i+1);
                element.remove(element.size() - 1);
            }
        }

    }
}
