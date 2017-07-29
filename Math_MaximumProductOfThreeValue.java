import java.util.Arrays;

/**
 * Created by yongchizhang on 17/7/21.
 */
public class Math_MaximumProductOfThreeValue {
    public class Solution {
        /*
        Algorithm

Another solution could be to sort the given numsnums array(in ascending order) and find out the product of the last three numbers. But, we can note that this product will be maximum only if all the numbers in numsnums array are positive. But, in the given problem statement, negative elements could exist as well. Thus, it could also be possible that two negative numbers lying at the left extreme end could also contribute to lead to a larger product if the third number in the triplet being considered is the largest positive number in the numsnums array. Thus, either the product nums[0]nums[0]xnums[1]nums[1]xnums[n-1]nums[n−1] or nums[n-3]nums[n−3]xnums[n-2]nums[n−2]xnums[n-1]nums[n−1] will give the required result. Thus, we need to find the larger one from out of these values.


        * */
        public int maximumProduct(int[] nums) {
            int min1 = Integer.MAX_VALUE, min2 = Integer.MAX_VALUE;
            int max1 = Integer.MIN_VALUE, max2 = Integer.MIN_VALUE, max3 = Integer.MIN_VALUE;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] < min1){
                    min2 = min1;
                    min1 = nums[i];
                }else if(nums[i] < min2){
                    min2 = nums[i];
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
            return Math.max(min1 * min2 * max1, max1 * max2 * max3);
        }
    }


    public class Solution2 {
        public int maximumProduct(int[] nums) {
            Arrays.sort(nums);
            return Math.max(nums[0] * nums[1] * nums[nums.length - 1], nums[nums.length - 1] * nums[nums.length - 2] * nums[nums.length - 3]);
        }
    }

}
