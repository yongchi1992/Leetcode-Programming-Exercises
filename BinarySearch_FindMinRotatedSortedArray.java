/**
 * Created by yongchizhang on 17/7/9.
 */
public class BinarySearch_FindMinRotatedSortedArray {
    public class Solution {
        public int findMin(int[] nums) {
            int start = 0, end = nums.length - 1;
            int target = nums[nums.length - 1];
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(nums[mid] < target){
                    end = mid - 1;
                }else if(nums[mid] > target){
                    start = mid + 1;
                }else if(nums[mid] == target){
                    return target;
                }
            }
            return nums[start];
        }
    }
}
