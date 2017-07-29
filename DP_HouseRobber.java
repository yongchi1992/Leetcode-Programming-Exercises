/**
 * Created by yongchizhang on 17/7/28.
 */
public class DP_HouseRobber {
    public class Solution {
        public int rob(int[] nums) {
            if(nums == null || nums.length == 0){
                return 0;
            }else if(nums.length == 1){
                return nums[0];
            }else if(nums.length == 2){
                return Math.max(nums[0], nums[1]);
            }

            int n = nums.length;
            int[] record = new int[n];
            record[n - 1] = nums[n - 1];
            record[n - 2] = Math.max(nums[n - 1], nums[n - 2]);
            for(int i = n - 3; i >= 0; i--){
                record[i] = Math.max(record[i + 1], nums[i] + record[i + 2]);
            }
            return record[0];
        }
    }
}
