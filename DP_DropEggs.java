/**
 * Created by yongchizhang on 17/7/24.
 */
public class DP_DropEggs {

    public class Solution_math {
        /**
         * @param n an integer
         * @return an integer
         */
        public int dropEggs(int n) {
            // Write your code here
            int i = 1;
            while( (long) i * (i + 1) < (long) 2 * n){
                i++;
            }
            return i;
        }
    }


    public class Solution {
        /**
         * @param n an integer
         * @return an integer
         */
        public int dropEggs(int n) {
            // Write your code here
            if(n <= 2){
                return n;
            }
            int[] record = new int[n];
            record[0] = 1;
            return helper(n, record);
        }
        public int helper(int n, int[] record){
            if (record[n - 1] != 0){
                return record[n - 1];
            }
            int res = Integer.MAX_VALUE;
            for (int m = 1; m < n; m++){
                res = Math.min(res, Math.max(m , helper(n - m, record) + 1));
            }
            record[n - 1] = res;
            return res;
        }
    }




}
