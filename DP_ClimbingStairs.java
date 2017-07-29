/**
 * Created by yongchizhang on 17/7/28.
 */
public class DP_ClimbingStairs {
    public class Solution {
        public int climbStairs(int n) {
            if(n <= 0){
                return 0;
            }
            if(n == 1 || n == 2){
                return n;
            }
            int[] record = new int[n];
            record[n - 1] = 1;
            record[n - 2] = 2;
            for(int i = n - 3; i >= 0; i--){
                record[i] = record[i + 1] + record[i + 2];
            }
            return record[0];
        }
    }
}
