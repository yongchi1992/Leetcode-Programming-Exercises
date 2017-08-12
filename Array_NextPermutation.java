/**
 * Created by yongchizhang on 17/8/12.
 */
public class Array_NextPermutation {



    public class Solution_best {
        public void nextPermutation(int[] nums) {
            int i = nums.length - 2;
            while (i >= 0 && nums[i + 1] <= nums[i]) {
                i--;
            }
            if (i >= 0) {
                int j = nums.length - 1;
                while (j >= 0 && nums[j] <= nums[i]) {
                    j--;
                }
                swap(nums, i, j);
            }
            reverse(nums, i + 1);
        }

        private void reverse(int[] nums, int start) {
            int i = start, j = nums.length - 1;
            while (i < j) {
                swap(nums, i, j);
                i++;
                j--;
            }
        }

        private void swap(int[] nums, int i, int j) {
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;
        }
    }




    public class Solution {
        public void nextPermutation(int[] nums) {
            int index = -1;
            for(int i = nums.length - 2; i >= 0; i--){
                if(nums[i] < nums[i + 1]){
                    index = i;
                    break;
                }
            }
            if(index == -1) {
                reverse(nums, 0, nums.length - 1);
                return;
            }
            for(int i = index + 1; i < nums.length; i++){
                if (nums[i] <= nums[index]){
                    swap(nums, index, i - 1);
                    reverse(nums, index + 1, nums.length - 1);
                    return;
                } else if (i == nums.length - 1){
                    swap(nums, index, i);
                    reverse(nums, index + 1, nums.length - 1);
                    return;
                }
            }
        }

        public void swap(int[] nums, int i, int j){
            if(i != j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }

        public void reverse(int[] nums, int i, int j) {
            while(i < j) {
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
                i++; j--;
            }
        }
    }
}
