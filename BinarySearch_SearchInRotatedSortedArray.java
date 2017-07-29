/**
 * Created by yongchizhang on 17/7/9.
 */
public class BinarySearch_SearchInRotatedSortedArray {
    public class Solution {
        public int search(int[] nums, int target) {
            if(nums.length == 0 || nums == null){
                return -1;
            }
            int minindex = findMin(nums);
            if(nums[minindex] == target){
                return minindex;
            }
            if(minindex == 0){
                return binarysearch(nums, 1, nums.length - 1, target);
            }else if(target > nums[nums.length - 1]){
                return binarysearch(nums, 0, minindex - 1, target);
            }else if(target <= nums[nums.length - 1]){
                return binarysearch(nums, minindex + 1, nums.length - 1, target);
            }
            return -1;
        }

        public int binarysearch(int[] nums, int start, int end, int target){
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[mid] == target){
                    return mid;
                }else if(nums[mid] < target){
                    start = mid + 1;
                }else if(nums[mid] > target){
                    end = mid - 1;
                }
            }
            return -1;
        }

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
                    return mid;
                }
            }
            return start;
        }
    }



    public class Solution2 {
        public int search(int[] nums, int target) {
            int start = 0, end = nums.length -1;
            while(start <= end){
                int mid = start + (end - start)/2;
                if(nums[mid] == target){
                    return mid;
                }else if(nums[start] <= nums[mid]){
                    if(target >= nums[start] && nums[mid] > target){
                        end = mid - 1;
                    }else{
                        start = mid + 1;
                    }
                }else{
                    if(target > nums[mid] && target <= nums[end]){
                        start = mid + 1;
                    }else{
                        end = mid - 1;
                    }
                }
            }
            return -1;
        }
    }
}
