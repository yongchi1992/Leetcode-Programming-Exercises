/**
 * Created by yongchizhang on 17/8/15.
 */
import java.util.*;
public class Backtracking_CombinationSum2 {
    public class Solution {

        public List<List<Integer>> combinationSum2(int[] candidates, int target) {
            List<List<Integer>> res = new LinkedList<>();
            if(candidates == null || candidates.length == 0){
                return  res;
            }
            List<Integer> list = new ArrayList<>();
            Arrays.sort(candidates);
            helper(candidates, 0, target, list, res);
            return res;
        }

        public void helper(int[] candidates, int idx, int target, List<Integer> list, List<List<Integer>> res){

            if(target == 0 && list.size() != 0){
                res.add(new ArrayList<Integer>(list));
            }
            if(idx == candidates.length){
                return;
            }
            for(int i = idx; i < candidates.length; i++){
                if(i > idx && candidates[i] == candidates[i - 1]){
                    continue;
                }
                if(target - candidates[i] < 0){
                    break;
                }
                list.add(candidates[i]);
                helper(candidates, i + 1, target - candidates[i], list, res);
                list.remove(list.size() - 1);
            }
        }
    }
}
