/**
 * Created by yongchizhang on 17/7/25.
 */
public class Math_FactorialTrailingZeroes {

    public class Solution {
        public int trailingZeroes(int n) {
            return n == 0 ? 0 : n / 5 + trailingZeroes(n / 5);
        }
    }

    public class Solution2 {
        public int trailingZeroes(int n) {
            int result = 0;
            for(long i = 5; n / i != 0; i *= 5){
                result += n / (int) i;
            }
            return result;
        }
    }

}
