/**
 * Created by yongchizhang on 17/7/26.
 */
public class Array_MaximumSubarray {
    public class Solution {
        public int maxSubArray(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }

            int[] record = new int[nums.length];
            record[0] = nums[0];
            int max = nums[0];
            for(int i = 1; i < nums.length; i++){
                if(record[i - 1] <= 0){
                    record[i] = nums[i];
                }else{
                    record[i] = record[i - 1] + nums[i];
                }
                if(record[i] > max){
                    max = record[i];
                }
            }
            return max;
        }
    }
}
