/**
 * Created by yongchizhang on 17/7/21.
 */
public class Math_RangeAddition2 {
    public class Solution {
        public int maxCount(int m, int n, int[][] ops) {
            int r_min = m, c_min = n;
            for(int i = 0; i < ops.length; i++){
                if(r_min > ops[i][0]){
                    r_min = ops[i][0];
                }
                if(c_min > ops[i][1]){
                    c_min = ops[i][1];
                }
            }
            return r_min * c_min;
        }
    }
}
