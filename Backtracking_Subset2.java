/**
 * Created by yongchizhang on 17/7/6.
 */
import java.util.*;
public class Backtracking_Subset2 {
    public class Solution {
        public List<List<Integer>> subsetsWithDup(int[] nums) {
            List<List<Integer>> result = new LinkedList<>();
            List<Integer> ele = new LinkedList<>();
            Arrays.sort(nums);
            helper(result, ele, nums, 0);
            return result;
        }
        public void helper(List<List<Integer>> result , List<Integer> ele, int[] nums, int pos){
            result.add(new LinkedList<Integer>(ele));
            for(int i = pos; i < nums.length; i++){
                if(i > pos && nums[i] == nums[i - 1]){
                    continue;
                }
                ele.add(nums[i]);
                helper(result, ele, nums, i+1);
                ele.remove(ele.size() - 1);
            }
        }
    }
}
