/**
 * Created by yongchizhang on 17/7/27.
 */
public class Array_RemoveDuplicatesFromSortedArray {
    //直接替换就行
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) return 0;
        int i = 0;
        for (int j = 1; j < nums.length; j++) {
            if (nums[j] != nums[i]) {
                i++;
                nums[i] = nums[j];
            }
        }
        return i + 1;
    }



    public class Solution {
        public int removeDuplicates(int[] nums) {
            int index = 0;
            for(int i = 1; i < nums.length; i++){
                if(nums[i] != nums[index]){
                    index++;
                    swap(nums, index, i);
                }
            }
            return index + 1;
        }
        public void swap(int[] nums, int i, int j){
            if(i != j){
                int temp = nums[i];
                nums[i] = nums[j];
                nums[j] = temp;
            }
        }
    }
}
