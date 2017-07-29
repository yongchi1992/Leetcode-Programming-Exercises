/**
 * Created by yongchizhang on 17/7/13.
 */
public class Math_IntegerBreak {
    public class Solution {
        public int integerBreak(int n) {
            // 2 <= n <= 58
            // 2, 3
            if(n == 2 || n == 3){
                return n - 1;
            }
            // 10 / 3 = 3
            int num_3 = n / 3;

            //remain 1
            int remain = n - 3 * num_3;

            if(remain == 0){
                return (int)Math.pow(3, num_3);
            }else if(remain == 1){
                return (int)Math.pow(3, num_3 - 1) * 4;
            }else{
                return (int)Math.pow(3, num_3 ) * 2;
            }
        }
    }
}
