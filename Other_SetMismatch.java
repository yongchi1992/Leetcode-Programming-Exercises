/**
 * Created by yongchizhang on 17/7/25.
 */
public class Other_SetMismatch {


    public class Solution2 {
        public int[] findErrorNums(int[] nums) {
            int[] result = new int[2];
            for(int i = 0; i < nums.length; i++){
                if(nums[Math.abs(nums[i]) - 1] < 0){
                    result[0] = Math.abs(nums[i]);
                }else{
                    nums[Math.abs(nums[i]) - 1] *= -1;
                }
            }
            for(int i = 0; i < nums.length; i++){
                if(nums[i] > 0){
                    result[1] = i + 1;
                    break;
                }
            }
            return result;
        }
    }

    public static int[] findErrorNums(int[] nums) {
        int[] res = new int[2];
        for (int i : nums) {
            if (nums[Math.abs(i) - 1] < 0) res[0] = Math.abs(i);
            else nums[Math.abs(i) - 1] *= -1;
        }
        for (int i=0;i<nums.length;i++) {
            if (nums[i] > 0) res[1] = i+1;
        }
        return res;
    }



    public class Solution {
        public int[] findErrorNums(int[] nums) {
            int n = nums.length;
            int[] record = new int[n + 1];
            int[] result = new int[2];
            for(int num: nums){
                record[num]++;
            }
            for(int i = 1; i <= n; i++){
                if(record[i] == 2){
                    result[0] = i;
                }else if(record[i] == 0){
                    result[1] = i;
                }
            }
            return result;
        }
    }
}
