/**
 * Created by yongchizhang on 17/7/6.
 */
import java.util.*;
public class Combinations {
    public class Solution {
        public List<List<Integer>> combine(int n, int k) {
            List<List<Integer>> result = new LinkedList<>();
            List<Integer> element = new LinkedList<>();
            helper(result, element, n, k, 1);
            return result;
        }
        public void helper(List<List<Integer>> result, List<Integer> element, int n, int k, int pos){
            if(k == 0){
                result.add(new LinkedList<Integer>(element));
                return;
            }
            for(int i = pos; i<= n - k + 1; i++){
                element.add(i);
                helper(result, element, n, k-1, i+1);
                element.remove(element.size() - 1);
            }
        }
    }
}
