import java.util.HashSet;

/**
 * Created by yongchizhang on 17/7/25.
 */
public class Math_SumOfSquareNum {
    public class Solution {
        public boolean judgeSquareSum(int c) {
            HashSet<Integer> square = new HashSet<>();
            for(int i = 0; (long) i * i <= (long) c; i++){
                square.add(i * i);
            }
            for(int num: square){      // HashSet 不是按照从小到大排列
                if(square.contains(c - num)){
                    return true;
                }
            }
            return false;
        }
    }


    public class Solution2 {
        public boolean judgeSquareSum(int c) {
            HashSet<Integer> set = new HashSet<Integer>();

            for (int i = 0; i <= Math.sqrt(c); i++) {
                set.add(i * i);
                if (set.contains(c - i * i)) {
                    return true;
                }
            }
            return false;
        }
    }


    public class Solution3 {
        public boolean judgeSquareSum(int c) {
            if (c < 0) {
                return false;
            }
            int left = 0, right = (int)Math.sqrt(c);
            while (left <= right) {
                int cur = left * left + right * right;
                if (cur < c) {
                    left++;
                } else if (cur > c) {
                    right--;
                } else {
                    return true;
                }
            }
            return false;
        }
    }


}
