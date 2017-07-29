import java.util.LinkedList;
import java.util.List;

/**
 * Created by yongchizhang on 17/7/6.
 */
public class Backtracking_CombinationSum3 {
    public class Solution {
        public List<List<Integer>> combinationSum3(int k, int n) {
            List<Integer> res = new LinkedList<>();
            List<List<Integer>> result = new LinkedList<>();
            helper(k,n,res,result, 1);
            return result;
        }
        public void helper(int k, int n, List<Integer> res, List<List<Integer>> result, int pos){
            if(n < pos){
                return;
            }
            if(k == 1){
                if(n>=pos && n<10){
                    res.add(n);
                    result.add(new LinkedList<Integer>(res));
                    res.remove(res.size() - 1);
                    return;
                }else{
                    return;
                }
            }
            for(int i = pos; i <= 9; i++){
                if(i < n){
                    res.add(i);
                    helper(k - 1, n - i, res, result, i+1);
                    res.remove(res.size() - 1);
                }
            }
        }
    }
}
