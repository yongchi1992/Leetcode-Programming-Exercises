/**
 * Created by yongchizhang on 17/8/1.
 */
public class Array_ProductofArrayExceptSelf {

    public class Solution_best {
        public int[] productExceptSelf(int[] nums) {
            int leng = nums.length;
            int[] ret = new int[leng];
            if(leng == 0)
                return ret;
            int runningprefix = 1;
            for(int i = 0; i < leng; i++){
                ret[i] = runningprefix;
                runningprefix*= nums[i];
            }
            int runningsufix = 1;
            for(int i = leng -1; i >= 0; i--){
                ret[i] *= runningsufix;
                runningsufix *= nums[i];
            }
            return ret;

        }
    }


    public class Solution {
        public int[] productExceptSelf(int[] nums) {
            long product = 1;
            int zeros = 0;
            int[] res = new int[nums.length];
            for(int num: nums){
                if(num == 0)    zeros++;
                else    product *= num;
            }
            for(int i = 0; i < nums.length; i++){
                if(zeros >= 2){
                    res[i] = 0;
                }else if(zeros == 1){
                    res[i] = nums[i] == 0 ? (int)product : 0;
                }else{
                    res[i] = (int)(product / nums[i]);
                }
            }
            return res;
        }
    }
}
