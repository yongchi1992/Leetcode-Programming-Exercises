/**
 * Created by yongchizhang on 17/7/26.
 */
public class Array_RemoveElement {
    public class Solution {
        public int removeElement(int[] nums, int val) {
            int lastPointer = 0;
            for(int i = 0; i < nums.length; i++){
                if(nums[i] != val){
                    swap(nums, lastPointer++, i);
                }
            }
            return lastPointer;
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
