import java.util.HashSet;

/**
 * Created by yongchizhang on 17/7/27.
 */
public class Array_ThirdMaximumNumber {


    public int thirdMax(int[] nums) {
        Integer max1 = null;
        Integer max2 = null;
        Integer max3 = null;
        for (Integer n : nums) {
            if (n.equals(max1) || n.equals(max2) || n.equals(max3)) continue;
            if (max1 == null || n > max1) {
                max3 = max2;
                max2 = max1;
                max1 = n;
            } else if (max2 == null || n > max2) {
                max3 = max2;
                max2 = n;
            } else if (max3 == null || n > max3) {
                max3 = n;
            }
        }
        return max3 == null ? max1 : max3;
    }




    public class Solution {
        public int thirdMax(int[] nums) {
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
            HashSet<Integer> record = new HashSet<>();
            for(int i = 0; i < nums.length; i++){
                if(record.size() < 3){
                    record.add(nums[i]);
                }
                if(nums[i] == max1 || nums[i] == max2 || nums[i] == max3){
                    continue;
                }
                if(nums[i] > max1){
                    max3 = max2;
                    max2 = max1;
                    max1 = nums[i];
                }else if(nums[i] > max2){
                    max3 = max2;
                    max2 = nums[i];
                }else if(nums[i] > max3){
                    max3 = nums[i];
                }
            }
            if(record.size() >= 3){
                return max3;
            }else{
                return max1;
            }
        }
    }
}
