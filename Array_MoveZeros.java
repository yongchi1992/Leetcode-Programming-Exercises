/**
 * Created by yongchizhang on 17/7/26.
 */
public class Array_MoveZeros {
    public class Solution3 {
        public void moveZeroes(int[] nums) {
            int p = -1;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    if(p != -1){
                        swap(nums, i, p);
                        p++;
                    }
                }else{
                    if(p == -1){
                        p = i;
                    }
                }
            }
        }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }





    public class Solution {
        public void moveZeroes(int[] nums) {
            int p = -1;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    if(p != -1 && i > p){
                        swap(nums, i, p);
                        while(nums[p] != 0){
                            p++;
                        }
                    }
                }else{
                    if(p == -1){
                        p = i;
                    }
                }
            }
        }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }




    public class Solution2 {
        public void moveZeroes(int[] nums) {
            int lastNoZero  = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != 0){
                    if(i != lastNoZero){
                        swap(nums, i, lastNoZero);
                    }
                    lastNoZero++;
                }
            }
        }
        public void swap(int[] nums, int i, int j){
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }
}
