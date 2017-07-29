import java.util.LinkedList;
import java.util.List;

/**
 * Created by yongchizhang on 17/7/5.
 */
public class Backtracking_BinaryWatch {
    public class Solution {
        public List<String> readBinaryWatch(int num) {
            int[] hours = {1, 2, 4, 8};
            int[] mins = {1, 2, 4, 8, 16, 32};
            List<String> result = new LinkedList<>();
            for(int i = 0; i <= hours.length; i++){
                if(num - i > mins.length){
                    continue;
                }
                LinkedList<Integer> n1 = numlist(hours, i);
                LinkedList<Integer> n2 = numlist(mins, num - i);
                for(int num1: n1){
                    if(num1 >= 12){
                        continue;
                    }
                    for(int num2 : n2){
                        if(num2 >= 60){
                            continue;
                        }
                        result.add(num1 + ":" + ((num2 < 10) ? "0" + num2 : num2));
                    }
                }
            }
            return result;
        }
        public LinkedList<Integer> numlist(int[] arr, int n){
            LinkedList<Integer> result = new LinkedList<>();
            helper(arr, n, 0, 0, result);
            return result;
        }

        public void helper(int[] arr, int n, int pos, int sum, LinkedList<Integer> result){
            if(n == 0){
                result.add(sum);
                return;
            }
            for(int i = pos; i < arr.length; i++){
                helper(arr, n - 1, i + 1, sum + arr[i], result);
            }
        }

    }
}
