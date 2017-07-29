/**
 * Created by yongchizhang on 17/7/13.
 */
public class Math_MissingNum {
    public class Solution {
        public int missingNumber(int[] nums) {
            int n = nums.length;
            long sum = (1 + n) * n / 2;
            long nums_sum = 0;
            for(int i = 0; i < n; i++){
                nums_sum += nums[i];
            }
            return (int)(sum - nums_sum);
        }
    }


    public int missingNumber(int[] nums) { //xor
        int res = nums.length;
        for(int i=0; i<nums.length; i++){
            res ^= i;
            res ^= nums[i];
        }
        return res;
    }

}
