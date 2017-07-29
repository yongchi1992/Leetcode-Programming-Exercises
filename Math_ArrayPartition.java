import java.util.Arrays;

/**
 * Created by yongchizhang on 17/7/26.
 */
public class Math_ArrayPartition {
    public class Solution {
        public int arrayPairSum(int[] nums) {
            Arrays.sort(nums);
            int result = 0;
            for(int i = 0; i < nums.length; i += 2){
                result += nums[i];
            }
            return result;
        }
    }
}
