/**
 * Created by yongchizhang on 17/8/2.
 */
public class BinarySearch_MinSizeSubSum {



    public class Solution_best {
        public int minSubArrayLen(int s, int[] nums) {
            int left = 0, sum = 0, min = Integer.MAX_VALUE;
            for(int i = 0; i < nums.length; i++){
                sum += nums[i];
                while(sum >= s){
                    min = Math.min(min, i - left + 1);
                    sum -= nums[left++];
                }
            }
            return min == Integer.MAX_VALUE ? 0 : min;
        }
    }



    public class Solution {
        public int minSubArrayLen(int s, int[] nums) {
            int[] sum = new int[nums.length + 1];
            for(int i = 0; i < nums.length; i++){
                if(nums[i] >= s){
                    return 1;
                }
                sum[i + 1] = sum[i] + nums[i];
            }
            if(sum[sum.length - 1] < s){
                return 0;
            }
            int min = Integer.MAX_VALUE;
            for(int i = 1; i < sum.length; i++){
                if(sum[i] < s){
                    continue;
                }else{
                    int index = findIndex(sum, sum[i] - s, 0, i - 1);
                    if(min > i - index){
                        min = i - index;
                    }
                }
            }
            return min;
        }
        public int findIndex(int[] sum, int target, int start, int end){
            while(start <= end){
                int mid = start + (end - start) / 2;
                if(sum[mid] < target){
                    start = mid + 1;
                }else if(sum[mid] > target){
                    end = mid - 1;
                }else if(sum[mid] == target){
                    return mid;
                }
            }
            return start - 1;
        }
    }
}
