/**
 * Created by yongchizhang on 8/26/17.
 */
public class Array_nondecreasingArray {
    // 属于分类讨论的问题
    class Solution {
        public boolean checkPossibility(int[] nums) {
            int cnt = 0;
            for(int i = 0; i < nums.length; i++){
                int left = (i == 0 ? Integer.MIN_VALUE : nums[i - 1]);
                int right = (i == nums.length - 1 ? Integer.MAX_VALUE : nums[i + 1]);
                if(nums[i] >= left && nums[i] <= right){
                    continue;
                } else {
                    if(right >= left){
                        nums[i] = left;
                        cnt++;
                    } else if(right < left){
                        if(nums[i] < left){
                            return false;
                        }
                    }
                    if(cnt >= 2){
                        return false;
                    }
                }
            }
            return true;
        }
    }
}
