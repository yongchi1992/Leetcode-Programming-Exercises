/**
 * Created by yongchizhang on 17/7/6.
 */
import java.util.*;
public class Backtracking_CombinationSum {
    public class Solution {
        public List<List<Integer>> combinationSum(int[] candidates, int target) {
            List<List<Integer>> result = new LinkedList<>();
            List<Integer> ele = new LinkedList<>();
            helper(result, ele, candidates, target, 0);
            return result;
        }
        public void helper(List<List<Integer>> result, List<Integer> ele, int[] candidates, int target, int pos){
            if(target == 0){
                result.add(new LinkedList<Integer>(ele));
                return;
            }
            for(int i = pos; i < candidates.length; i++){
                int c = candidates[i];
                if(target>=c){
                    ele.add(c);
                    helper(result, ele, candidates, target - c, i);
                    ele.remove(ele.size() - 1);
                }
            }
        }
    }
}
