import java.util.ArrayList;
import java.util.List;

/**
 * Created by yongchizhang on 17/8/13.
 */


//The set of numbers without 9s is the same as the set of base-9 numbers, and they occur in the same order.
// The answer is therefore just the n-th base-9 number.


public class Math_Remove9 {
    public class Solution {
        public int newInteger(int n) {
            List<Integer> res = new ArrayList<>();
            while(n > 0) {
                res.add(n % 9);
                n /= 9;
            }
            int result = 0;
            for(int i = res.size() - 1; i >= 0; i--){
                result = result * 10 + res.get(i);
            }
            return result;
        }
    }
}
